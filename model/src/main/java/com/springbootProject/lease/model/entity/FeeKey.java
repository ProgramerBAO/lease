package com.springbootProject.lease.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 杂项费用名称表
 * @TableName fee_key
 */
@TableName(value ="fee_key")
@Data
public class FeeKey extends BaseEntity {
    /**
     * 付款项key
     */
    @Schema(description = "付款项key")
    private String name;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}