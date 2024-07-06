package com.springbootProject.lease.web.admin.controller.apartment;

import com.springbootProject.lease.common.result.Result;
import com.springbootProject.lease.web.admin.service.FileService;
import io.minio.errors.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Tag(name = "文件上传")
@RequestMapping("/admin/file")
@RestController
public class FileUploadController {
    @Resource
    private FileService fileService;

    @Operation(summary = "上传文件")
    @PostMapping("upload") // MultipartFile 是springboot自带的
    public Result<String> upload(@RequestParam MultipartFile file) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        String url = fileService.upload(file);
        return Result.ok(url);
    }
}
