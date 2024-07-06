package com.springbootProject.lease.common.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author BobShen
 * @date 27/06/2024 23:31
 */
@Configuration
@MapperScan("com.springbootProject.lease.web.*.mapper")
public class MybatisPlusConfiguration {
}
