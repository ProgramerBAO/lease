package com.springbootProject.lease.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.springbootProject.lease.model.enums.BaseStatus;

/**
 * 用户信息表
 * @TableName user_info
 */
@TableName(value ="user_info")
@Data
@Schema(description = "用户信息表")
public class UserInfo extends BaseEntity {
    /**
     * 手机号码（用做登录用户名）
     */
    @Schema(description = "手机号码（用做登录用户名）")
    @TableField(value = "phone")
    private String phone;

    /**
     * 密码
     */
    @Schema(description = "密码")
    @TableField(value = "password",select = false)
    private String password;

    /**
     * 头像url
     */
    @Schema(description = "头像url")
    @TableField(value = "avatar_url")
    private String avatarUrl;

    /**
     * 昵称
     */
    @Schema(description = "昵称")
    @TableField(value = "nickname")
    private String nickname;

    /**
     * 账号状态
     */
    @Schema(description = "账号状态(1：启用，0：禁用)")
    @TableField(value = "status")
    private BaseStatus status;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}