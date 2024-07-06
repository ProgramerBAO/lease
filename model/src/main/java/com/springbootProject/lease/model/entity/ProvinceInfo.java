package com.springbootProject.lease.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 
 * @TableName province_info
 */
@TableName(value ="province_info")
@Data
@Schema(description = "省份信息表")
public class ProvinceInfo extends BaseEntity {

    @Schema(description = "省份名称")
    @TableField(value = "name")
    private String name;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}