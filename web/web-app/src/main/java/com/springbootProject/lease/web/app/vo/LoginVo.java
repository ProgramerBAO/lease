package com.springbootProject.lease.web.app.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LoginVo {
    @Schema(description = "用户手机号码")
    private String phone;
    @Schema(description = "短信验证码")
    private String code;
}
