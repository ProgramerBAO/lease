package com.springbootProject.lease.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 公寓&杂费关联表
 * @TableName apartment_fee_value
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="apartment_fee_value")
@Data
public class ApartmentFeeValue extends BaseEntity {
    /**
     * 公寓id
     */
    private Long apartmentId;
    /**
     * 收费项value_id
     */
    private Long feeValueId;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}