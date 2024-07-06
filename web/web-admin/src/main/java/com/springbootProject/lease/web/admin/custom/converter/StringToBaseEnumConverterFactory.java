package com.springbootProject.lease.web.admin.custom.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

import com.springbootProject.lease.model.enums.BaseEnum;

// 通用枚举转换器工厂
@Component
public class StringToBaseEnumConverterFactory implements ConverterFactory<String, BaseEnum> {

    @Override
    public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
        return (String code) -> {
            System.out.println("调用了转换函数");
            if (targetType.isEnum()) {
                T[] enumConstants = targetType.getEnumConstants();
                for (T enumConstant : enumConstants) {
                    if (enumConstant.getCode().equals(Integer.valueOf(code))) {
                        return enumConstant;
                    }
                }
            }
            
            throw new IllegalArgumentException("无法匹配对应的枚举类型");
        };
    }

    // @Override
    // public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
    //     return new Converter<String, T>() {
    //         @Override
    //         public T convert(String code) {
    //             System.out.println("调用了转换函数");
    //             if (targetType.isEnum()) {
    //                 // 获取枚举类型
    //                 T[] enumConstants = targetType.getEnumConstants();
    //                 for (T enumConstant : enumConstants) {
    //                     if (enumConstant.getCode().equals(Integer.valueOf(code))) {
    //                         return enumConstant;
    //                     }
    //                 }
    //             }
    //             throw new IllegalArgumentException("无法匹配对应的枚举类型");
    //         }
    //     };
    // }

}