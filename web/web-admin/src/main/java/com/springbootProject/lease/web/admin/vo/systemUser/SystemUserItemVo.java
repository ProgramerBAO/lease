package com.springbootProject.lease.web.admin.vo.systemUser;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.springbootProject.lease.model.entity.SystemUser;

@Data
public class SystemUserItemVo extends SystemUser {
    @Schema(description = "岗位名称")
    @TableField(value = "post_name")
    private String postName;
}
