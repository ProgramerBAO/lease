package com.springbootProject.lease.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum ItemType implements BaseEnum {
    APARTMENT(1, "公寓"),
    ROOM(2, "房间");


    @EnumValue // 枚举值
    @JsonValue // 枚举值
    private final Integer code;
    private final String name;
}
