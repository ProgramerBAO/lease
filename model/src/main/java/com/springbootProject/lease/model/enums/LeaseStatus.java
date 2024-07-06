package com.springbootProject.lease.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum LeaseStatus implements BaseEnum{
	SIGNING(1, "签约待确认"),
	SIGNED(2, "已签约"),
	CANCELED(3, "已取消"),
	EXPIRED(4, "已到期"),
	WITHDRAWING(5, "退租待确认"),
	WITHDRAWN(6, "已退租"),
	RENEWING(7, "续约待确认");

	@EnumValue
	@JsonValue
	private final Integer code;
	private final String name;

	public static LeaseStatus getEnumByCode(Integer code) {
		for (LeaseStatus e : LeaseStatus.values()) {
			if (e.code.equals(code)) {
				return e;
			}
		}
		return null;
	}

	@Override
	public String getName() {
		return name;
	}
}