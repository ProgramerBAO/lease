package com.springbootProject.lease.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootProject.lease.model.entity.ApartmentInfo;
import com.springbootProject.lease.web.app.vo.apartment.ApartmentItemVo;

/**
* @author 86183
* @description 针对表【apartment_info(公寓信息表)】的数据库操作Mapper
* @createDate 2024-06-18 22:50:27
* @Entity generator.domain.ApartmentInfo
*/
public interface ApartmentInfoMapper extends BaseMapper<ApartmentInfo> {

    ApartmentItemVo getApartmentByRoomId(Long apartmentId);
}




