package com.springbootProject.lease.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 房间&基本属性值关联表
 * @TableName room_attr_value
 */
@TableName(value ="room_attr_value")
@Data
public class RoomAttrValue extends BaseEntity {
    /**
     * 房间id
     */
    private Long roomId;

    /**
     * 属性值id
     */
    private Long attrValueId;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}