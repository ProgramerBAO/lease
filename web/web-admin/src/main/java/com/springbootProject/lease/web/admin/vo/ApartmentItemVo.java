package com.springbootProject.lease.web.admin.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.springbootProject.lease.model.entity.ApartmentInfo;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "后台管理系统公寓列表实体")
public class ApartmentItemVo extends ApartmentInfo {
    @Schema(description = "房间总数")
    private Long totalRoomCount;

    @Schema(description = "空置房间数")
    private Long freeRoomCount;
}
