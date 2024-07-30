package com.springbootProject.lease.web.app.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootProject.lease.model.entity.PaymentType;
import com.springbootProject.lease.web.app.mapper.PaymentTypeMapper;
import com.springbootProject.lease.web.app.service.PaymentTypeService;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.List;

@Service
public class PaymentTypeServiceImpl extends ServiceImpl<PaymentTypeMapper, PaymentType> implements PaymentTypeService {

    @Resource
    private PaymentTypeMapper paymentTypeMapper;

    @Override
    public List<PaymentType> listPaymentByRoomId(Long id) {
        return paymentTypeMapper.getPaymentTypeByRoomIt(id);
    }
}




