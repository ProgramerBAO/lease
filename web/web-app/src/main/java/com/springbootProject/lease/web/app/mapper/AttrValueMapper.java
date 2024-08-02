package com.springbootProject.lease.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootProject.lease.model.entity.AttrValue;
import com.springbootProject.lease.web.app.vo.attrvalue.AttrValueVo;

import java.util.List;

/**
* @author BobShen
* @description 针对表【attr_value(房间基本属性值表)】的数据库操作Mapper
* @createDate 2024-06-18 22:50:27
* @Entity generator.domain.AttrValue
*/
public interface AttrValueMapper extends BaseMapper<AttrValue> {
    List<AttrValueVo> getAttrValueByRoomId(Long id);
}




