package com.springbootProject.lease.web.app.service;

// 创建一个短信服务接口
public interface SmsService {
    void sendCode(String phone,String code);
}
