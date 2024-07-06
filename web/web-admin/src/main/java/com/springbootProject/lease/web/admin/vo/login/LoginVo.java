package com.springbootProject.lease.web.admin.vo.login;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "后台管理系统登录请求实体")
public class LoginVo {
    @Schema(description = "用户名")
    private String usename;
    @Schema(description = "密码")
    private String password;
    @Schema(description = "验证码code")
    private String captchaCode;
    @Schema(description = "验证码key")
    private String captchaKey;
}
