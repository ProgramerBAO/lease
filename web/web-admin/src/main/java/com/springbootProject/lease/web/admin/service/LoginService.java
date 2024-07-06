package com.springbootProject.lease.web.admin.service;

import com.springbootProject.lease.web.admin.vo.login.CaptchaVo;
import com.springbootProject.lease.web.admin.vo.login.LoginVo;
import com.springbootProject.lease.web.admin.vo.systemUser.SystemUserInfoVo;

public interface LoginService {

    CaptchaVo getCaptcha();

    String login(LoginVo loginVo);


    SystemUserInfoVo getLoginUserInfoById(Long userId);
}
