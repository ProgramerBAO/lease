package com.springbootProject.lease.web.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springbootProject.lease.model.entity.ApartmentInfo;
import com.springbootProject.lease.web.app.vo.apartment.ApartmentDetailVo;

/**
* @author BobShen
* @description 针对表【apartment_info(公寓信息表)】的数据库操作Service
* @createDate 2024-06-18 22:50:27
*/
public interface ApartmentInfoService extends IService<ApartmentInfo> {

    ApartmentDetailVo getApartmentDetailById(Long id);
}
