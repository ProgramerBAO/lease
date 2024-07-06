package com.springbootProject.lease.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum LeaseSourceType {
	NEW(1, "新签"),
	RENEW(2, "续约");

	@EnumValue
	@JsonValue
	private final Integer code;
	private final String name;

	public static LeaseSourceType getEnumByCode(Integer code) {
		for (LeaseSourceType e : LeaseSourceType.values()) {
			if (e.code.equals(code)) {
				return e;
			}
		}
		return null;
	}
} 