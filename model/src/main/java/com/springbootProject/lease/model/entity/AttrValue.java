package com.springbootProject.lease.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 房间基本属性值表
 * @TableName attr_value
 */
@TableName(value ="attr_value")
@Data
@Schema(description = "房间基本属性值表")
public class AttrValue extends BaseEntity {
    /**
     * 属性value
     */
    @Schema(description = "属性value")
    @TableField(value = "name")
    private String name;

    /**
     * 对应的属性key_id
     */
    @Schema(description = "对应的属性keyId")
    @TableField(value = "attr_key_id")
    private Long attrKeyId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}