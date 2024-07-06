package com.springbootProject.lease.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 杂项费用值表
 * @TableName fee_value
 */
@TableName(value ="fee_value")
@Data
public class FeeValue extends BaseEntity {
    /**
     * 费用value
     */
    @Schema(description = "费用value")
    private String name;

    /**
     * 收费单位
     */
    @Schema(description = "收费单位")
    private String unit;

    /**
     * 费用所对的fee_key
     */
    @Schema(description = "费用所对的fee_key")
    private Long feeKeyId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}