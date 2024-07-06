package com.springbootProject.lease.web.admin.vo.appointment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.springbootProject.lease.model.entity.ApartmentInfo;
import com.springbootProject.lease.model.entity.ViewAppointment;

@Schema(description = "预约看房展示实体")
@Data
public class AppointmentVo extends ViewAppointment {
    @Schema(description = "房间所在公寓信息")
    private ApartmentInfo apartmentInfo;
}
