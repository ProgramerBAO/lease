package com.springbootProject.lease.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.springbootProject.lease.model.enums.ItemType;

/**
 * 图片信息表
 * @TableName graph_info
 */
@TableName(value ="graph_info")
@Data
public class GraphInfo extends BaseEntity {
    /**
     * 图片名称
     */
    @TableField(value = "name")
    @Schema(description = "图片名称")
    private String name;

    /**
     * 图片所属对象类型（1:apartment,2:room）
     */
    @Schema(description = "图片所属对象类型（1:apartment,2:room）")
    @TableField(value = "item_type")
    private ItemType itemType;

    /**
     * 图片所有对象id
     */
    @Schema(description = "图片所有对象id")
    @TableField(value = "item_id")
    private Long itemId;

    /**
     * 图片地址
     */
    @Schema(description = "图片地址")
    @TableField(value = "url")
    private String url;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}