package com.springbootProject.lease.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.springbootProject.lease.model.enums.AppointmentStatus;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 预约看房信息表
 * @TableName view_appointment
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="view_appointment")
@Data
@Schema(description = "预约看房信息表")
public class ViewAppointment extends BaseEntity {
    /**
     * 用户id
     */
    @Schema(description = "用户id")
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 用户姓名
     */
    @Schema(description = "用户姓名")
    @TableField(value = "name")
    private String name;

    /**
     * 用户手机号码
     */
    @Schema(description = "用户手机号码")
    @TableField(value = "phone")
    private String phone;

    /**
     * 公寓id
     */
    @Schema(description = "公寓id")
    @TableField(value = "apartment_id")
    private Integer apartmentId;

    /**
     * 预约时间
     */
    @Schema(description = "预约时间")
    @TableField(value = "appointment_time")
    private Date appointmentTime;

    /**
     * 备注信息
     */
    @Schema(description = "备注信息")
    @TableField(value = "additional_info")
    private String additionalInfo;

    /**
     * 预约状态（1:待看房，2:已取消，3已看房）
     */
    @Schema(description = "预约状态（1:待看房，2:已取消，3:已看房）")
    @TableField(value = "appointment_status")
    private AppointmentStatus appointmentStatus;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}