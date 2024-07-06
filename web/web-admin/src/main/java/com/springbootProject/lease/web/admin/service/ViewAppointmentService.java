package com.springbootProject.lease.web.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springbootProject.lease.model.entity.ViewAppointment;
import com.springbootProject.lease.web.admin.vo.appointment.AppointmentVo;
import com.springbootProject.lease.web.admin.vo.lease.AppointmentQueryVo;

/**
* @author BobShen
* @description 针对表【view_appointment(预约看房信息表)】的数据库操作Service
* @createDate 2024-06-18 22:50:28
*/
public interface ViewAppointmentService extends IService<ViewAppointment> {

    IPage<AppointmentVo> pageAppointmentByQuery(IPage<AppointmentVo> page, AppointmentQueryVo appointmentVo);
}
