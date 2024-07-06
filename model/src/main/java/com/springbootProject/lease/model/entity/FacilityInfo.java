package com.springbootProject.lease.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.springbootProject.lease.model.enums.ItemType;

/**
 * 配套信息表
 * @TableName facility_info
 */
@TableName(value ="facility_info")
@Data
public class FacilityInfo extends BaseEntity {

    @Schema(description = "类型（1:公寓图片,2:房间图片）")
    @TableField(value = "type")
    private ItemType type;

    @Schema(description = "名称")
    @TableField(value = "name")
    private String name;

    @Schema(description = "图标")
    @TableField(value = "icon")
    private String icon;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}