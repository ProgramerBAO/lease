package com.springbootProject.lease.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 公寓&配套关联表
 * @TableName apartment_facility
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="apartment_facility")
@Data
public class ApartmentFacility extends BaseEntity {
    /**
     * 公寓id
     */
    private Long apartmentId;

    /**
     * 设施id
     */
    private Long facilityId;


    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}