package com.springbootProject.lease.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 房间&标签关联表
 * @TableName room_label
 */
@TableName(value ="room_label")
@Data
public class RoomLabel extends BaseEntity {
    /**
     * 房间id
     */
    private Long roomId;

    /**
     * 标签id
     */
    private Long labelId;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}