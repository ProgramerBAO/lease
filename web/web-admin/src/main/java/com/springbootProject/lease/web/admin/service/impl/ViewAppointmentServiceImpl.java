package com.springbootProject.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootProject.lease.model.entity.ViewAppointment;
import com.springbootProject.lease.web.admin.mapper.ViewAppointmentMapper;
import com.springbootProject.lease.web.admin.service.ViewAppointmentService;
import com.springbootProject.lease.web.admin.vo.appointment.AppointmentVo;
import com.springbootProject.lease.web.admin.vo.lease.AppointmentQueryVo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;



/**
* @author 86183
* @description 针对表【view_appointment(预约看房信息表)】的数据库操作Service实现
* @createDate 2024-06-18 22:50:28
*/
@Service
public class ViewAppointmentServiceImpl extends ServiceImpl<ViewAppointmentMapper, ViewAppointment>
    implements ViewAppointmentService {

    @Resource
    private ViewAppointmentMapper viewAppointmentMapper;
    @Override
    public IPage<AppointmentVo> pageAppointmentByQuery(IPage<AppointmentVo> page, AppointmentQueryVo appointmentVo) {
        return viewAppointmentMapper.pageAppointmentByQuery(page,appointmentVo);
    }
}




