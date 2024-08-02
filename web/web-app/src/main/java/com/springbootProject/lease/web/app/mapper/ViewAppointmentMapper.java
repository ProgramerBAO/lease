package com.springbootProject.lease.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootProject.lease.model.entity.ViewAppointment;
import com.springbootProject.lease.web.app.vo.viewappointment.ViewAppointmentVo;

import java.util.List;

/**
* @author BobShen
* @description 针对表【view_appointment(预约看房信息表)】的数据库操作Mapper
* @createDate 2024-07-02 14:42:56
* @Entity com.springbootProject.lease.domain.ViewAppointment
*/
public interface ViewAppointmentMapper extends BaseMapper<ViewAppointment> {

    List<ViewAppointmentVo> selectAppointMentListByUserId(Long userId);
}




