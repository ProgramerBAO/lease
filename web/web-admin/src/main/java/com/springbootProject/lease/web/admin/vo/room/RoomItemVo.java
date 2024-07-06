package com.springbootProject.lease.web.admin.vo.room;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.springbootProject.lease.model.entity.ApartmentInfo;
import com.springbootProject.lease.model.entity.RoomInfo;

import java.util.Date;

@Data
@Schema(description = "房间信息展示实体")
public class RoomItemVo extends RoomInfo {
    @Schema(description = "租约结束时间")
    private Date leaseEndDate;
    @Schema(description = "当前入住状态")
    private Boolean isCheckIn;
    @Schema(description = "所属公寓信息")
    private ApartmentInfo apartmentInfo;
}
