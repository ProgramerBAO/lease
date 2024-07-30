package com.springbootProject.lease.web.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springbootProject.lease.model.entity.PaymentType;

import java.util.List;

/**
* @author 86183
* @description 针对表【payment_type(支付方式表)】的数据库操作Service
* @createDate 2024-06-15 17:14:56
*/
public interface PaymentTypeService extends IService<PaymentType> {

    List<PaymentType> listPaymentByRoomId(Long id);
}
