package com.springbootProject.lease;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author BobShen
 * @date 27/06/2024 23:12
 */
@SpringBootApplication
@EnableScheduling // 开启定时任务
public class AdminWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminWebApplication.class, args);
    }
}
