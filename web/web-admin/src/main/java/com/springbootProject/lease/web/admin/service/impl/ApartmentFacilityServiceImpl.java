package com.springbootProject.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootProject.lease.model.entity.ApartmentFacility;
import com.springbootProject.lease.web.admin.mapper.ApartmentFacilityMapper;
import com.springbootProject.lease.web.admin.service.ApartmentFacilityService;
import org.springframework.stereotype.Service;

/**
* @author BobShen
* @description 针对表【apartment_facility(公寓&配套关联表)】的数据库操作Service实现
* @createDate 2024-06-18 22:50:27
*/
@Service
public class ApartmentFacilityServiceImpl extends ServiceImpl<ApartmentFacilityMapper, ApartmentFacility>
    implements ApartmentFacilityService {

}




