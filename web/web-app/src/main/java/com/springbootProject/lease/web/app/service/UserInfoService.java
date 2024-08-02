package com.springbootProject.lease.web.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springbootProject.lease.model.entity.UserInfo;
import com.springbootProject.lease.web.app.vo.user.UserInfoVo;

/**
* @author BobShen
* @description 针对表【user_info(用户信息表)】的数据库操作Service
* @createDate 2024-06-18 22:50:28
*/
public interface UserInfoService extends IService<UserInfo> {
    UserInfoVo getUserInfoById();
}
