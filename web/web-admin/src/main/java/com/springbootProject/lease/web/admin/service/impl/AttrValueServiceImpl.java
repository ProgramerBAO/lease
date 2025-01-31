package com.springbootProject.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootProject.lease.model.entity.AttrValue;
import com.springbootProject.lease.web.admin.mapper.AttrValueMapper;
import com.springbootProject.lease.web.admin.service.AttrValueService;
import org.springframework.stereotype.Service;

/**
* @author BobShen
* @description 针对表【attr_value(房间基本属性值表)】的数据库操作Service实现
* @createDate 2024-06-18 22:50:27
*/
@Service
public class AttrValueServiceImpl extends ServiceImpl<AttrValueMapper, AttrValue>
    implements AttrValueService {

}




