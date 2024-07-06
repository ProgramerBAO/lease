package com.springbootProject.lease.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootProject.lease.model.entity.PaymentType;
import com.springbootProject.lease.model.entity.RoomPaymentType;

import java.util.List;

/**
* @author BobShen
* @description 针对表【room_payment_type(房间&支付方式关联表)】的数据库操作Mapper
* @createDate 2024-06-18 22:50:28
* @Entity generator.domain.RoomPaymentType
*/
public interface RoomPaymentTypeMapper extends BaseMapper<RoomPaymentType> {

    List<PaymentType> selectListByRoomId(Long id);
}




