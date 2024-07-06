package com.springbootProject.lease.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 房间租期管理表
 * @TableName room_lease_term
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="room_lease_term")
@Data
public class RoomLeaseTerm extends BaseEntity {
    /**
     * 房间id
     */
    private Long roomId;

    /**
     * 租期id
     */
    private Long leaseTermId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}