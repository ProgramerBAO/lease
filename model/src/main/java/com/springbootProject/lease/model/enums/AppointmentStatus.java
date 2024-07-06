package com.springbootProject.lease.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.AllArgsConstructor;
@Getter
@AllArgsConstructor
public enum AppointmentStatus implements BaseEnum{
	WAITING(1, "待看房"),
	CANCELED(2, "已取消"),
	VIEWED(3, "已看房");

	@EnumValue
	@JsonValue
	private final Integer code;

	private final String name;

	public static AppointmentStatus getEnumByCode(Integer code) {
		for (AppointmentStatus e : AppointmentStatus.values()) {
			if (e.code.equals(code)) {
				return e;
			}
		}
		return null;
	}
} 