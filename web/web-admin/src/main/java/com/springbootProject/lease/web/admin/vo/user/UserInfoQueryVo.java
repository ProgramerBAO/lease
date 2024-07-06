package com.springbootProject.lease.web.admin.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.springbootProject.lease.model.enums.BaseStatus;

@Data
@Schema(description = "用户信息查询条件")
public class UserInfoQueryVo {
    @Schema(description = "用户手机号码")
    private String phone;

    @Schema(description = "用户状态")
    private BaseStatus status;
}
