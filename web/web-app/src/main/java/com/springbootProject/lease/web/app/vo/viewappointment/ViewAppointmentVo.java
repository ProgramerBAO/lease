package com.springbootProject.lease.web.app.vo.viewappointment;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.springbootProject.lease.model.enums.AppointmentStatus;
import com.springbootProject.lease.web.app.vo.graph.GraphVo;

import java.util.Date;
import java.util.List;

@Data
@Schema(description = "App端预约看房基本信息")
public class ViewAppointmentVo {
    @Schema(description = "预约Id")
    private Long id;

    @Schema(description = "预约公寓名称")
    private String apartmentName;

    @Schema(description = "公寓预约状态")
    private AppointmentStatus appointmentStatus;

    @Schema(description = "预约公寓预约时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date appointmentTime;

    @Schema(description = "预约公寓图片列表")
    private List<GraphVo> graphVoList;
}
