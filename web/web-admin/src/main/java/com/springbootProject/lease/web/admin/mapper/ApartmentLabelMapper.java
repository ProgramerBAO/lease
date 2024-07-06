package com.springbootProject.lease.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootProject.lease.model.entity.ApartmentLabel;
import com.springbootProject.lease.model.entity.LabelInfo;

import java.util.List;

/**
* @author 86183
* @description 针对表【apartment_label(公寓标签关联表)】的数据库操作Mapper
* @createDate 2024-06-18 22:50:27
* @Entity generator.domain.ApartmentLabel
*/
public interface ApartmentLabelMapper extends BaseMapper<ApartmentLabel> {

    List<LabelInfo> selectListByItemTypeAndId(Long id);
}




