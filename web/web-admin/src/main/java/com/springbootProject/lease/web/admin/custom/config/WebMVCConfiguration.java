package com.springbootProject.lease.web.admin.custom.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springbootProject.lease.web.admin.custom.converter.StringToBaseEnumConverterFactory;

import jakarta.annotation.Resource;


@Configuration
public class WebMVCConfiguration implements WebMvcConfigurer{

    @Resource
    private StringToBaseEnumConverterFactory stringToBaseEnumConverterFactory;
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(this.stringToBaseEnumConverterFactory);
    }
}
