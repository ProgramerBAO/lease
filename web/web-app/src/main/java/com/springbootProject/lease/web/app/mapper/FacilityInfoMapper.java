package com.springbootProject.lease.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootProject.lease.model.entity.FacilityInfo;

import java.util.List;

/**
* @author BobShen
* @description 针对表【facility_info(配套信息表)】的数据库操作Mapper
* @createDate 2024-06-18 22:50:27
* @Entity generator.domain.FacilityInfo
*/
public interface FacilityInfoMapper extends BaseMapper<FacilityInfo> {

    List<FacilityInfo> getFacilityInfoByRoomId(Long id);

    List<FacilityInfo> listFacilityInfoByApartmentId(Long id);
}




