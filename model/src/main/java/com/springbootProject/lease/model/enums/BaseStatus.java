package com.springbootProject.lease.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.AllArgsConstructor;
@Getter
@AllArgsConstructor
public enum BaseStatus {
	ENABLE(1, "启用"),
	DISABLE(0, "禁用");

	@EnumValue
	@JsonValue
	private final Integer code;
	private final String name;

	public static BaseStatus getEnumByCode(Integer code) {
		for (BaseStatus e : BaseStatus.values()) {
			if (e.code.equals(code)) {
				return e;
			}
		}
		return null;
	}
} 