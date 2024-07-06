package com.springbootProject.lease.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootProject.lease.model.entity.LeaseTerm;
import com.springbootProject.lease.model.entity.RoomLeaseTerm;

import java.util.List;

/**
* @author 86183
* @description 针对表【room_lease_term(房间租期管理表)】的数据库操作Mapper
* @createDate 2024-06-18 22:50:28
* @Entity generator.domain.RoomLeaseTerm
*/
public interface RoomLeaseTermMapper extends BaseMapper<RoomLeaseTerm> {

    List<LeaseTerm> selectListByRoomId(Long id);
}




