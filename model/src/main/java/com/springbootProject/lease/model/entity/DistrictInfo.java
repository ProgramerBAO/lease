package com.springbootProject.lease.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 
 * @TableName district_info
 */
@TableName(value ="district_info")
@Data
@Schema(description = "地区信息表")
public class DistrictInfo extends BaseEntity {


    @TableField(value = "name")
    @Schema(description = "区域名称")
    private String name;


    @Schema(description = "城市Id")
    @TableField(value = "city_id")
    private Integer cityId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}