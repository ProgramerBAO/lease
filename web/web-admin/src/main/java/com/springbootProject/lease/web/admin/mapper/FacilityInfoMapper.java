package com.springbootProject.lease.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootProject.lease.model.entity.FacilityInfo;

import java.util.List;

/**
* @author 86183
* @description 针对表【facility_info(配套信息表)】的数据库操作Mapper
* @createDate 2024-06-18 22:50:27
* @Entity generator.domain.FacilityInfo
*/
public interface FacilityInfoMapper extends BaseMapper<FacilityInfo> {

    List<FacilityInfo> selectListByRoomId(Long id);
}




