package com.springbootProject.lease.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootProject.lease.model.entity.ViewAppointment;
import com.springbootProject.lease.web.app.mapper.ApartmentInfoMapper;
import com.springbootProject.lease.web.app.mapper.ViewAppointmentMapper;
import com.springbootProject.lease.web.app.service.ViewAppointmentService;
import com.springbootProject.lease.web.app.vo.apartment.ApartmentItemVo;
import com.springbootProject.lease.web.app.vo.viewappointment.ViewAppointmentDetailVo;
import com.springbootProject.lease.web.app.vo.viewappointment.ViewAppointmentVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.List;

/**
* @author BobShen
* @description 针对表【view_appointment(预约看房信息表)】的数据库操作Service实现
* @createDate 2024-07-02 14:42:56
*/
@Service
public class ViewAppointmentServiceImpl extends ServiceImpl<ViewAppointmentMapper, ViewAppointment>
    implements ViewAppointmentService{

    @Resource
    private ViewAppointmentMapper viewAppointmentMapper;
    @Resource
    private ApartmentInfoMapper apartmentInfoMapper;


    @Override
    public List<ViewAppointmentVo> listAppointmentByUserId(Long userId) {
        return viewAppointmentMapper.selectAppointMentListByUserId(userId);
    }

    @Override
    public ViewAppointmentDetailVo getAppointmentDetailById(Long id) {
        ViewAppointment viewAppointment = super.getById(id);
        ViewAppointmentDetailVo viewAppointmentDetailVo = new ViewAppointmentDetailVo();
        ApartmentItemVo apartmentItemVo=apartmentInfoMapper.getApartmentByRoomId(Long.valueOf(viewAppointment.getApartmentId()));
        BeanUtils.copyProperties(viewAppointment,viewAppointmentDetailVo);
        viewAppointmentDetailVo.setApartmentItemVo(apartmentItemVo);
        return viewAppointmentDetailVo;
    }
}




