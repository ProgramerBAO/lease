package com.springbootProject.lease.web.admin.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootProject.lease.model.entity.PaymentType;
import com.springbootProject.lease.web.admin.mapper.PaymentTypeMapper;
import com.springbootProject.lease.web.admin.service.PaymentTypeService;
import org.springframework.stereotype.Service;

@Service
public class PaymentTypeServiceImpl extends ServiceImpl<PaymentTypeMapper, PaymentType> implements PaymentTypeService{
}




