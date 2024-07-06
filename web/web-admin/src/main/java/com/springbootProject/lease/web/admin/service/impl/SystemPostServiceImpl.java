package com.springbootProject.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootProject.lease.model.entity.SystemPost;
import com.springbootProject.lease.web.admin.mapper.SystemPostMapper;
import com.springbootProject.lease.web.admin.service.SystemPostService;
import org.springframework.stereotype.Service;

/**
* @author 86183
* @description 针对表【system_post(岗位信息表)】的数据库操作Service实现
* @createDate 2024-06-18 22:50:28
*/
@Service
public class SystemPostServiceImpl extends ServiceImpl<SystemPostMapper, SystemPost>
    implements SystemPostService {

}




