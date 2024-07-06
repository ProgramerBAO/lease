package com.springbootProject.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootProject.lease.model.entity.GraphInfo;
import com.springbootProject.lease.web.admin.mapper.GraphInfoMapper;
import com.springbootProject.lease.web.admin.service.GraphInfoService;
import org.springframework.stereotype.Service;

/**
* @author BobShen
* @description 针对表【graph_info(图片信息表)】的数据库操作Service实现
* @createDate 2024-06-18 22:50:27
*/
@Service
public class GraphInfoServiceImpl extends ServiceImpl<GraphInfoMapper, GraphInfo>
    implements GraphInfoService {

}




