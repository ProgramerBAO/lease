package com.springbootProject.lease.web.admin.vo.fee;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.springbootProject.lease.model.entity.FeeKey;
import com.springbootProject.lease.model.entity.FeeValue;

import java.util.List;

@Data
public class FeeKeyVo extends FeeKey {
    @Schema(description = "杂费value列表")
    private List<FeeValue> feeValueList;
}
