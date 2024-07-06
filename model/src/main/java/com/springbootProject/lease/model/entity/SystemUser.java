package com.springbootProject.lease.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.springbootProject.lease.model.enums.BaseStatus;
import com.springbootProject.lease.model.enums.SystemUserType;

/**
 * 员工信息表
 * @TableName system_user
 */
@TableName(value ="system_user")
@Data
@Schema(description = "员工信息表")
public class SystemUser extends BaseEntity {
    /**
     * 用户名
     */
    @Schema(description = "用户名")
    @TableField(value = "username")
    private String username;

    /**
     * 密码
     */
    @Schema(description = "密码")
    @TableField(value = "password",select = false)
    private String password;

    /**
     * 姓名
     */
    @Schema(description = "姓名")
    @TableField(value = "name")
    private String name;

    /**
     * 用户类型
     */
    @Schema(description = "用户类型(0：管理员，1：普通用户，2：店长，3：业务员)")
    @TableField(value = "type")
    private SystemUserType type;

    /**
     * 手机号码
     */
    @Schema(description = "手机号码")
    @TableField(value = "phone")
    private String phone;

    /**
     * 头像地址
     */
    @Schema(description = "头像地址")
    @TableField(value = "avatar_url")
    private String avatarUrl;

    /**
     * 备注信息
     */
    @Schema(description = "备注信息")
    @TableField(value = "additional_info")
    private String additionalInfo;

    /**
     * 岗位id
     */
    @Schema(description = "岗位id")
    @TableField(value = "post_id")
    private Long postId;

    /**
     * 账号状态
     */
    @Schema(description = "账号状态")
    @TableField(value = "status")
    private BaseStatus status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}