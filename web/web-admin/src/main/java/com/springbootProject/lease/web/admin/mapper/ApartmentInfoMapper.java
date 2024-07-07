package com.springbootProject.lease.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springbootProject.lease.model.entity.ApartmentInfo;
import com.springbootProject.lease.web.admin.vo.ApartmentItemVo;
import com.springbootProject.lease.web.admin.vo.apartment.ApartmentQueryVo;

/**
* @author BobShen
* @description 针对表【apartment_info(公寓信息表)】的数据库操作Mapper
* @createDate 2024-06-18 22:50:27
* @Entity generator.domain.ApartmentInfo
*/
public interface ApartmentInfoMapper extends BaseMapper<ApartmentInfo> {
    // queryVo在这里定义了
    IPage<ApartmentItemVo> pageApartmentListByQuery(IPage<ApartmentItemVo> page, ApartmentQueryVo queryVo);
}




