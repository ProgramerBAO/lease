package com.springbootProject.lease.web.app.vo.room;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Schema(description = "房间信息查询实体")
public class RoomQueryVo implements Serializable {
    @Schema(description = "省份Id")
    private Long provinceId;

    @Schema(description = "城市Id")
    private Long cityId;

    @Schema(description = "地区Id")
    private Long districtId;

    @Schema(description = "最大租金")
    private BigDecimal maxRent;

    @Schema(description = "最小租金")
    private BigDecimal minRent;

    @Schema(description = "支付方式Id")
    private Long paymentTypeId;

    @Schema(description = "价格排序方式",allowableValues = {"desc","asc"})
    private String orderType;
}
