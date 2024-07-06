package com.springbootProject.lease.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 房间&配套关联表
 * @TableName room_facility
 */
@TableName(value ="room_facility")
@Data
public class RoomFacility extends BaseEntity {
    /**
     * 房间id
     */
    private Long roomId;

    /**
     * 房间设施id
     */
    private Long facilityId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}