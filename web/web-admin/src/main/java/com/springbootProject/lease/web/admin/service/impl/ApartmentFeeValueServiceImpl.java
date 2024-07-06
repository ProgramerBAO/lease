package com.springbootProject.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootProject.lease.model.entity.ApartmentFeeValue;
import com.springbootProject.lease.web.admin.mapper.ApartmentFeeValueMapper;
import com.springbootProject.lease.web.admin.service.ApartmentFeeValueService;
import org.springframework.stereotype.Service;

/**
* @author BobShen
* @description 针对表【apartment_fee_value(公寓&杂费关联表)】的数据库操作Service实现
* @createDate 2024-06-18 22:50:27
*/
@Service
public class ApartmentFeeValueServiceImpl extends ServiceImpl<ApartmentFeeValueMapper, ApartmentFeeValue>
    implements ApartmentFeeValueService {

}




