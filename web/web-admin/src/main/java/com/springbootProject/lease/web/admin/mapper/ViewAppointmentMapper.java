package com.springbootProject.lease.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springbootProject.lease.model.entity.ViewAppointment;
import com.springbootProject.lease.web.admin.vo.appointment.AppointmentVo;
import com.springbootProject.lease.web.admin.vo.lease.AppointmentQueryVo;

/**
* @author BobShen
* @description 针对表【view_appointment(预约看房信息表)】的数据库操作Mapper
* @createDate 2024-06-18 22:50:28
* @Entity generator.domain.ViewAppointment
*/
public interface ViewAppointmentMapper extends BaseMapper<ViewAppointment> {

    IPage<AppointmentVo> pageAppointmentByQuery(IPage<AppointmentVo> page, AppointmentQueryVo appointmentVo);
}




