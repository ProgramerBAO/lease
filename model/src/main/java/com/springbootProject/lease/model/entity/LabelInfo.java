package com.springbootProject.lease.model.entity;

import java.io.Serial;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.springbootProject.lease.model.enums.ItemType;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "标签信息表")
@TableName(value = "label_info")
@Data
@EqualsAndHashCode(callSuper = false)
public class LabelInfo extends BaseEntity {
    @Serial
    @Schema(description = "序列化")
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Schema(description = "类型")
    @TableField(value = "type")
    @JsonProperty(value = "type")
    private ItemType type;


    @Schema(description = "标签名称")
    @TableField(value = "name")
    @JsonProperty(value = "name")
    private String name;

}