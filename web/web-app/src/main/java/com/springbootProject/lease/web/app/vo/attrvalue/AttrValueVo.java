package com.springbootProject.lease.web.app.vo.attrvalue;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.springbootProject.lease.model.entity.AttrValue;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public class AttrValueVo extends AttrValue implements Serializable {
    @Schema(description = "属性值")
    private Long attrKeyId;
    @Schema(description = "属性值名称")
    private String attrKeyName;
}
