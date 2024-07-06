package com.springbootProject.lease.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootProject.lease.model.entity.RoomAttrValue;
import com.springbootProject.lease.web.admin.vo.room.AttrValueVo;

import java.util.List;

/**
* @author BobShen
* @description 针对表【room_attr_value(房间&基本属性值关联表)】的数据库操作Mapper
* @createDate 2024-06-18 22:50:28
* @Entity generator.domain.RoomAttrValue
*/
public interface RoomAttrValueMapper extends BaseMapper<RoomAttrValue> {

    List<AttrValueVo> selectListByRoomId(Long id);
}




