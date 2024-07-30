package com.springbootProject.lease.web.app.vo.feevalue;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "公寓杂费信息实体")
public class FeeValueVo implements Serializable {
    @Schema(description = "杂费键")
    private Long feeKeyId;
    @Schema(description = "杂费值")
    private String feeKeyName;
    @Schema(description = "杂费名称")
    private String name;
    @Schema(description = "杂费单位")
    private String unit;
}
