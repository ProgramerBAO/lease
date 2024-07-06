package com.springbootProject.lease.web.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springbootProject.lease.model.entity.RoomInfo;
import com.springbootProject.lease.web.admin.vo.room.RoomDetailVo;
import com.springbootProject.lease.web.admin.vo.room.RoomItemVo;
import com.springbootProject.lease.web.admin.vo.room.RoomQueryVo;
import com.springbootProject.lease.web.admin.vo.room.RoomSubmitVo;

/**
* @author BobShen
* @description 针对表【room_info(房间信息表)】的数据库操作Service
* @createDate 2024-06-18 22:50:28
*/
public interface RoomInfoService extends IService<RoomInfo> {

    void saveOrUpdateRoom(RoomSubmitVo roomSubmitVo);

    IPage<RoomItemVo> pageRoomItemByQuery(IPage<RoomItemVo> page, RoomQueryVo roomQueryVo);

    RoomDetailVo getRoomDetailById(Long id);

    void removeRoomById(Long id);
}
