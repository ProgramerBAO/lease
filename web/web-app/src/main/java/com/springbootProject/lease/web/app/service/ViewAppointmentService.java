package com.springbootProject.lease.web.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springbootProject.lease.model.entity.ViewAppointment;
import com.springbootProject.lease.web.app.vo.viewappointment.ViewAppointmentDetailVo;
import com.springbootProject.lease.web.app.vo.viewappointment.ViewAppointmentVo;

import java.util.List;

/**
* @author BobShen
* @description 针对表【view_appointment(预约看房信息表)】的数据库操作Service
* @createDate 2024-07-02 14:42:56
*/
public interface ViewAppointmentService extends IService<ViewAppointment> {

    List<ViewAppointmentVo> listAppointmentByUserId(Long userId);

    ViewAppointmentDetailVo getAppointmentDetailById(Long id);
}
