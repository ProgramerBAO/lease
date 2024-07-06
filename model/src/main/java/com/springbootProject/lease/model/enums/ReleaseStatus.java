package com.springbootProject.lease.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.AllArgsConstructor;
@Getter
@AllArgsConstructor
public enum ReleaseStatus {
	RELEASED(1, "发布"),
	NOT_RELEASED(0, "未发布");

	@EnumValue
	@JsonValue
	private final Integer code;
	private final String name;

	public static ReleaseStatus getEnumByCode(Integer code) {
		for (ReleaseStatus e : ReleaseStatus.values()) {
			if (e.code.equals(code)) {
				return e;
			}
		}
		return null;
	}
} 