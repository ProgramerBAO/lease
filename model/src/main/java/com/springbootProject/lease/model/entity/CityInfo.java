package com.springbootProject.lease.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 
 * @TableName city_info
 */
@TableName(value ="city_info")
@Data
@Schema(description = "城市信息表")
public class CityInfo extends BaseEntity {

    @Schema(description = "城市名称")
    @TableField(value = "name")
    private String name;

    @Schema(description = "省份Id")
    @TableField(value = "province_id")
    private Integer provinceId;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}