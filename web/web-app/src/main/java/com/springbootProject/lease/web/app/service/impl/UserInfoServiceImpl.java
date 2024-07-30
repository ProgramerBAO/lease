package com.springbootProject.lease.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springbootProject.lease.common.login.LoginUserHolder;
import com.springbootProject.lease.model.entity.UserInfo;
import com.springbootProject.lease.web.app.mapper.UserInfoMapper;
import com.springbootProject.lease.web.app.service.UserInfoService;
import com.springbootProject.lease.web.app.vo.user.UserInfoVo;
import org.springframework.stereotype.Service;

/**
* @author 86183
* @description 针对表【user_info(用户信息表)】的数据库操作Service实现
* @createDate 2024-06-18 22:50:28
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService {

    @Override
    public UserInfoVo getUserInfoById() {
        Long userId = LoginUserHolder.getLoginUser().getUserId();
        UserInfo userInfo = super.getById(userId);
        return new UserInfoVo(userInfo.getNickname(),userInfo.getAvatarUrl());
    }
}




