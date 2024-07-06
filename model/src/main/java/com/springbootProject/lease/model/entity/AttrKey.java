package com.springbootProject.lease.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 房间基本属性表
 * @TableName attr_key
 */
@TableName(value ="attr_key")
@Data
@Schema(description = "房间基本属性表")
public class AttrKey extends BaseEntity {
    /**
     * 属性key
     */
    @Schema(description = "属性key")
    @TableField(value = "name")
    private String name;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}