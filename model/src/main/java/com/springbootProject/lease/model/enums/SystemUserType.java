package com.springbootProject.lease.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.AllArgsConstructor;
@Getter
@AllArgsConstructor
public enum SystemUserType {
	ADMIN(0, "管理员"),
	USER(1, "普通用户"),
	SHOPOWNER(2, "店长"),
	SALESMAN(3, "业务员");

	@EnumValue
	@JsonValue
	private final Integer code;
	private final String name;

	public static SystemUserType getEnumByCode(Integer code) {
		for (SystemUserType e : SystemUserType.values()) {
			if (e.code.equals(code)) {
				return e;
			}
		}
		return null;
	}
} 