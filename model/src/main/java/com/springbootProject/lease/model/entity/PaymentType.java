package com.springbootProject.lease.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 支付方式表
 * @TableName payment_type
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="payment_type")
@Data
public class PaymentType extends BaseEntity {

    @Schema(description = "付款方式名称")
    @TableField(value = "name")
    private String name;

    @Schema(description = "每次支付租期数")
    @TableField(value = "pay_month_count")
    private Integer payMonthCount;

    @Schema(description = "付费说明")
    @TableField(value = "additional_info")
    private String additionalInfo;


    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}