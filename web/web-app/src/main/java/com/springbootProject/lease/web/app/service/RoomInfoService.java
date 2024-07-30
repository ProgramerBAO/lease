package com.springbootProject.lease.web.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springbootProject.lease.model.entity.RoomInfo;
import com.springbootProject.lease.web.app.vo.room.RoomDetailVo;
import com.springbootProject.lease.web.app.vo.room.RoomItemVo;
import com.springbootProject.lease.web.app.vo.room.RoomQueryVo;

/**
* @author 86183
* @description 针对表【room_info(房间信息表)】的数据库操作Service
* @createDate 2024-06-18 22:50:28
*/
public interface RoomInfoService extends IService<RoomInfo> {
    IPage<RoomItemVo> pageRoomItemByQuery(IPage<RoomItemVo> page, RoomQueryVo queryVo);

    RoomDetailVo getRoomDetailById(Long id);

    IPage<RoomItemVo> pageRoomItemByApartmentId(IPage<RoomItemVo> page, Long apartmentId);
}
