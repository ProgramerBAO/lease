package com.springbootProject.lease.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.springbootProject.lease.model.enums.LeaseSourceType;
import com.springbootProject.lease.model.enums.LeaseStatus;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 租约信息表
 * @TableName lease_agreement
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="lease_agreement")
@Data
@Schema(description = "租约信息表")
public class LeaseAgreement extends BaseEntity {
    /**
     * 承租人手机号码
     */
    @Schema(description = "承租人手机号码")
    @TableField(value = "phone")
    private String phone;

    /**
     * 承租人姓名
     */
    @Schema(description = "承租人姓名")
    @TableField(value = "name")
    private String name;

    /**
     * 承租人身份证号码
     */
    @Schema(description = "承租人身份证号码")
    @TableField(value = "identification_number")
    private String identificationNumber;

    /**
     * 签约公寓id
     */
    @Schema(description = "签约公寓id")
    @TableField(value = "apartment_id")
    private Long apartmentId;

    /**
     * 签约房间id
     */
    @Schema(description = "签约房间id")
    @TableField(value = "room_id")
    private Long roomId;

    /**
     * 租约开始日期
     */
    @Schema(description = "租约开始日期")
    @TableField(value = "lease_start_date")
    private Date leaseStartDate;

    /**
     * 租约结束日期
     */
    @Schema(description = "租约结束日期")
    @TableField(value = "lease_end_date")
    private Date leaseEndDate;

    /**
     * 租期id
     */
    @Schema(description = "租期id")
    @TableField(value = "lease_term_id")
    private Long leaseTermId;

    /**
     * 租金（元/月）
     */
    @Schema(description = "租金（元/月）")
    @TableField(value = "rent")
    private BigDecimal rent;

    /**
     * 押金（元）
     */
    @Schema(description = "押金（元）")
    @TableField(value = "deposit")
    private BigDecimal deposit;

    /**
     * 支付类型id

     */
    @Schema(description = "支付类型id")
    @TableField(value = "payment_type_id")
    private Long paymentTypeId;

    /**
     * 租约状态（1:签约待确认，2:已签约，3:已取消，4:已到期，5:退租待确认，6:已退租，7:续约待确认）
     */
    @Schema(description = "租约状态（1:签约待确认，2:已签约，3:已取消，4:已到期，5:退租待确认，6:已退租，7:续约待确认）")
    @TableField(value = "status")
    private LeaseStatus status;

    /**
     * 租约来源（1:新签，2:续约）
     */
    @Schema(description = "租约来源（1:新签，2:续约）")
    @TableField(value = "source_type")
    private LeaseSourceType sourceType;

    /**
     * 备注信息
     */
    @Schema(description = "备注信息")
    @TableField(value = "additional_info")
    private String additionalInfo;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}