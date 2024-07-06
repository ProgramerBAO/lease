package com.springbootProject.lease.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 房间信息表
 * @TableName room_info
 */
@TableName(value ="room_info")
@Data
@Schema(description = "房间信息表")
public class RoomInfo extends BaseEntity {
    /**
     * 房间号
     */
    @Schema(description = "房间号")
    @TableField(value = "room_number")
    private String roomNumber;

    /**
     * 租金（元/月）
     */
    @Schema(description = "租金（元/月）")
    @TableField(value = "rent")
    private BigDecimal rent;

    /**
     * 所属公寓id
     */
    @Schema(description = "所属公寓id")
    @TableField(value = "apartment_id")
    private Long apartmentId;

    /**
     * 是否发布
     */
    @Schema(description = "是否发布")
    @TableField(value = "is_release")
    private Integer isRelease;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}