package com.springbootProject.lease.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable { // 和grpc有异曲同工之妙
    @Schema(description = "主键")
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @Schema(description = "创建时间")
    @JsonIgnore // 不显示在swagger文档中
    @TableField(value = "create_time",fill = FieldFill.INSERT) // 插入时填充
    private Date createTime;

    @Schema(description = "修改时间")
    @JsonIgnore
    @TableField(value = "update_time",fill = FieldFill.UPDATE) // 更新时填充
    private Date updateTime;

    @Schema(description = "逻辑删除")
    @JsonIgnore
    @TableField(value = "is_deleted")
    @TableLogic // 逻辑删除 默认为0
    private Byte isDeleted;
}
