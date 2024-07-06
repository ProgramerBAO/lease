package com.springbootProject.lease.web.admin.vo.attr;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.springbootProject.lease.model.entity.AttrKey;
import com.springbootProject.lease.model.entity.AttrValue;

import java.util.List;


@Data
public class AttrKeyVo extends AttrKey {
    @Schema(description = "属性值列表")
    private List<AttrValue> attrValueList;
}
