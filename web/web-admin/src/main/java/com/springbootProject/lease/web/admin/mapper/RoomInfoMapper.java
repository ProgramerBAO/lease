package com.springbootProject.lease.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springbootProject.lease.model.entity.RoomInfo;
import com.springbootProject.lease.web.admin.vo.room.RoomItemVo;
import com.springbootProject.lease.web.admin.vo.room.RoomQueryVo;

/**
* @author 86183
* @description 针对表【room_info(房间信息表)】的数据库操作Mapper
* @createDate 2024-06-18 22:50:28
* @Entity generator.domain.RoomInfo
*/
public interface RoomInfoMapper extends BaseMapper<RoomInfo> {

    IPage<RoomItemVo> pageRoomItemByQuery(IPage<RoomItemVo> page, RoomQueryVo roomQueryVo);
}




