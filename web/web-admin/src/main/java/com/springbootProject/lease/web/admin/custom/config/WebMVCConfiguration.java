package com.springbootProject.lease.web.admin.custom.config;

import com.springbootProject.lease.web.admin.custom.converter.StringToBaseEnumConverterFactory;
import com.springbootProject.lease.web.admin.custom.interceptor.AuthenticationInterceptor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMVCConfiguration implements WebMvcConfigurer{

    @Resource
    private StringToBaseEnumConverterFactory stringToBaseEnumConverterFactory;
    @Resource
    private AuthenticationInterceptor authenticationInterceptor;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(this.stringToBaseEnumConverterFactory);
    }

    // 拦截器注册
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.authenticationInterceptor)
                .excludePathPatterns("/admin/login/**") // 排除登录接口
                .addPathPatterns("/admin/**"); // 限制拦截范围
    }
}
