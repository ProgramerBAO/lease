package com.springbootProject.lease.web.app.service;

import com.springbootProject.lease.web.app.vo.LoginVo;

public interface LoginService {
    void getCode(String phone);

    String login(LoginVo loginVo);
}
