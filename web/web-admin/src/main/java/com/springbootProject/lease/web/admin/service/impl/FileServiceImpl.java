package com.springbootProject.lease.web.admin.service.impl;

import com.springbootProject.lease.common.minio.MinioProperties;
import com.springbootProject.lease.web.admin.service.FileService;
import io.minio.*;
import io.minio.errors.*;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Resource
    private MinioProperties minioProperties;
    @Resource
    private MinioClient minioClient;

    @Override
    public String upload(MultipartFile file)
            throws ServerException, InsufficientDataException,
            ErrorResponseException, IOException, NoSuchAlgorithmException,
            InvalidKeyException, InvalidResponseException, XmlParserException,
            InternalException {
        boolean bucketExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(minioProperties.getBucketName()).build());

        if (!bucketExists) {
            minioClient.makeBucket(MakeBucketArgs
                    .builder()
                    .bucket(minioProperties.getBucketName())
                    .build());
            minioClient.setBucketPolicy(SetBucketPolicyArgs
                    .builder()
                    .bucket(minioProperties.getBucketName())
                    .config(createBucketPolicyConfig(minioProperties.getBucketName()))
                    .build());
        }

        String filename = new SimpleDateFormat("yyyyMMdd").format(new Date()) +
                "/" + UUID.randomUUID() + "-" + file.getOriginalFilename(); // 斜杠指的是 根目录
        minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket(minioProperties.getBucketName())
                        .stream(file.getInputStream(), file.getSize(), -1) // 上传文件流 获取文件大小
                        .object(filename)
                        .contentType(file.getContentType())// 文件类型 决定了是在网页展示还是直接下载下来
                        .build());

        return String.join("/", minioProperties.getEndpoint(), minioProperties.getBucketName(), filename);
    }

    private String createBucketPolicyConfig(String bucketName) {

        StringBuilder policy = new StringBuilder();

        policy.append("{\n");
        policy.append("    \"Statement\": [\n");
        policy.append("        {\n");
        policy.append("            \"Action\": \"s3:GetObject\",\n");
        policy.append("            \"Effect\": \"Allow\",\n");
        policy.append("            \"Principal\": \"*\",\n");
        policy.append("            \"Resource\": \"arn:aws:s3:::");
        policy.append(bucketName);
        policy.append("/*\"\n");
        policy.append("        }\n");
        policy.append("    ],\n");
        policy.append("    \"Version\": \"2012-10-17\"\n");
        policy.append("}\n");
        System.out.println("策略：" + policy);

        return policy.toString();
    }
}
