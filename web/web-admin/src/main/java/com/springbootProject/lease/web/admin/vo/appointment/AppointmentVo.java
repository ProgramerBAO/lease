package com.springbootProject.lease.web.admin.vo.appointment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.springbootProject.lease.model.entity.ApartmentInfo;
import com.springbootProject.lease.model.entity.ViewAppointment;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Schema(description = "预约看房展示实体")
@Data
public class AppointmentVo extends ViewAppointment {
    // 连表查询 包含了ApartmentInfo  ViewAppointment 两张表的数据
    @Schema(description = "房间所在公寓信息")
    private ApartmentInfo apartmentInfo;
}
