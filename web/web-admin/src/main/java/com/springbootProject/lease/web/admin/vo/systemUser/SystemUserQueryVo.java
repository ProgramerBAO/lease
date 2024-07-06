package com.springbootProject.lease.web.admin.vo.systemUser;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "系统用户查询条件")
public class SystemUserQueryVo {
    @Schema(description = "用户名")
    private String name;
    @Schema(description = "手机号")
    private String phone;
}
