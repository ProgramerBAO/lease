package com.springbootProject.lease.web.admin.vo.apartment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "公寓查询实体")
@Data
public class ApartmentQueryVo {
    @Schema(description = "省份id")
    private Long provinceId;

    @Schema(description = "城市id")
    private Long cityId;

    @Schema(description = "区域id")
    private Long districtId;

}
