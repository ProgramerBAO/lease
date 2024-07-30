package com.springbootProject.lease.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootProject.lease.model.entity.PaymentType;

import java.util.List;

/**
* @author 86183
* @description 针对表【payment_type(支付方式表)】的数据库操作Mapper
* @createDate 2024-06-15 17:14:56
* @Entity PaymentType
*/
public interface PaymentTypeMapper extends BaseMapper<PaymentType> {

    List<PaymentType> getPaymentTypeByRoomIt(Long id);
}




