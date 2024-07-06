package com.springbootProject.lease.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 租期
 * @TableName lease_term
 */
@TableName(value ="lease_term")
@Data
public class LeaseTerm extends BaseEntity {
    @Schema(description ="租期" )
    @TableField(value = "month_count")
    private Integer monthCount;


    @Schema(description = "租期单位")
    @TableField(value = "unit")
    private String unit;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}