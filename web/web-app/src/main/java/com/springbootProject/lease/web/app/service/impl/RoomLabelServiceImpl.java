package com.springbootProject.lease.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootProject.lease.model.entity.RoomLabel;
import com.springbootProject.lease.web.app.mapper.RoomLabelMapper;
import com.springbootProject.lease.web.app.service.RoomLabelService;
import org.springframework.stereotype.Service;

/**
* @author BobShen
* @description 针对表【room_label(房间&标签关联表)】的数据库操作Service实现
* @createDate 2024-06-18 22:50:28
*/
@Service
public class RoomLabelServiceImpl extends ServiceImpl<RoomLabelMapper, RoomLabel>
    implements RoomLabelService {

}




