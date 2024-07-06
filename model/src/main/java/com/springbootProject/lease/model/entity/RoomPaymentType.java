package com.springbootProject.lease.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 房间&支付方式关联表
 * @TableName room_payment_type
 */
@TableName(value ="room_payment_type")
@Data
public class RoomPaymentType extends BaseEntity {
    /**
     * 房间id
     */
    private Long roomId;

    /**
     * 支付类型id
     */
    private Long paymentTypeId;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}