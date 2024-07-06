package com.springbootProject.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootProject.lease.model.entity.UserInfo;
import com.springbootProject.lease.web.admin.mapper.UserInfoMapper;
import com.springbootProject.lease.web.admin.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
* @author 86183
* @description 针对表【user_info(用户信息表)】的数据库操作Service实现
* @createDate 2024-06-18 22:50:28
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{
}




