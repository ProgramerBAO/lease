package com.springbootProject.lease.web.admin.vo.systemUser;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "后台用户基本信息")
@Data
public class SystemUserInfoVo {
    @Schema(description = "用户姓名")
    private String name;

    @Schema(description = "用户头像")
    private String avatarUrl;
}
