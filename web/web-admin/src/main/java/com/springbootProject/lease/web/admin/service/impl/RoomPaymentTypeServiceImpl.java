package com.springbootProject.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootProject.lease.model.entity.RoomPaymentType;
import com.springbootProject.lease.web.admin.mapper.RoomPaymentTypeMapper;
import com.springbootProject.lease.web.admin.service.RoomPaymentTypeService;
import org.springframework.stereotype.Service;

/**
* @author 86183
* @description 针对表【room_payment_type(房间&支付方式关联表)】的数据库操作Service实现
* @createDate 2024-06-18 22:50:28
*/
@Service
public class RoomPaymentTypeServiceImpl extends ServiceImpl<RoomPaymentTypeMapper, RoomPaymentType>
    implements RoomPaymentTypeService {

}




