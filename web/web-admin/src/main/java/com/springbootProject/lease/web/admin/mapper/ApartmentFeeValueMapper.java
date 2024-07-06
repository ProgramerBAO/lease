package com.springbootProject.lease.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootProject.lease.model.entity.ApartmentFeeValue;
import com.springbootProject.lease.web.admin.vo.apartment.FeeValueVo;

import java.util.List;

/**
* @author BobShen
* @description 针对表【apartment_fee_value(公寓&杂费关联表)】的数据库操作Mapper
* @createDate 2024-06-18 22:50:27
* @Entity generator.domain.ApartmentFeeValue
*/
public interface ApartmentFeeValueMapper extends BaseMapper<ApartmentFeeValue> {

    List<FeeValueVo> selectListByItemTypeAndId(Long id);
}




