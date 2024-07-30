package com.springbootProject.lease;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author BobShen
 * @date 28/07/2024 02:00
 */
@SpringBootApplication
@EnableScheduling // 开启定时任务
public class AppWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppWebApplication.class, args);
    }
}
