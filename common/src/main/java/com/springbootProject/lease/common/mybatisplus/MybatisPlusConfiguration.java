package com.springbootProject.lease.common.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author BobShen
 * @date 27/06/2024 23:31
 */
@Configuration
@MapperScan("com.springbootProject.lease.web.*.mapper")
public class MybatisPlusConfiguration {
    @Bean // 拦截器 用于配置插件 为什么是拦截器呢?是因为拦截器给正常的查询添加自定义规则
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 分页插件 增加分页规则
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
