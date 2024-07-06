package com.springbootProject.lease.web.admin.vo.lease;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "预约看房查询实体")
public class AppointmentQueryVo {
    @Schema(description = "预约用户姓名")
    private String name;
    @Schema(description = "预约用户手机号")
    private String phone;
    @Schema(description = "公寓所在省id")
    private Long provinceId;
    @Schema(description = "公寓所在市id")
    private Long cityId;
    @Schema(description = "公寓所在区id")
    private Long districtId;
    @Schema(description = "公寓id")
    private Long apartmentId;
}
