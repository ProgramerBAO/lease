package com.springbootProject.lease.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 公寓标签关联表
 * @TableName apartment_label
 */
@TableName(value ="apartment_label")
@Data
public class ApartmentLabel extends BaseEntity {
    /**
     * 公寓id
     */
    private Long apartmentId;

    /**
     * 标签id
     */
    private Long labelId;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}