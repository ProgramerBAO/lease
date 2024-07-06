package com.springbootProject.lease.web.admin.vo.room;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "房间信息查询实体")
public class RoomQueryVo {
    @Schema(description = "省份Id")
    private Long provinceId;

    @Schema(description = "城市Id")
    private Long cityId;

    @Schema(description = "区县Id")
    private Long districtId;

    @Schema(description = "公寓Id")
    private Long apartmentId;
}
