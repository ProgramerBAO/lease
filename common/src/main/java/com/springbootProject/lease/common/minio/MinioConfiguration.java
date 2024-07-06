package com.springbootProject.lease.common.minio;

import io.minio.MinioClient;
import jakarta.annotation.Resource;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MinioProperties.class) // 启用配置属性
// 扫描配置属性 这个配置和上面那个是一个作用 配置参数较多时候使用这个
@ConfigurationPropertiesScan("com.springbootProject.lease.common.minio")
public class MinioConfiguration {
    /*第一种读取配置文件 application.yml属性值的方法begin*/
    //@Value("${minio.endpoint}")
    //private String endpoint;
    /*第一种读取配置文件 application.yml属性值的方法end*/
    @Resource
    private MinioProperties properties;

    @Bean
    public MinioClient minioClient() {
        /*第一种读取配置文件 application.yml属性值的方法begin*/
        //return MinioClient.builder().endpoint(endpoint).credentials(properties.getAccessKey(), properties.getSecretKey()).build();

        return MinioClient.builder().endpoint(properties.getEndpoint()).credentials(properties.getAccessKey(), properties.getSecretKey()).build();
    }
}
