package com.springbootProject.lease.web.app.service.impl;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.springbootProject.lease.web.app.service.SmsService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl implements SmsService {

    @Resource
    private Client client;

    @Override
    public void sendCode(String phone, String code) {
        // 发送短信
        SendSmsRequest smsRequest = new SendSmsRequest();
        smsRequest.setPhoneNumbers(phone)
                .setSignName("阿里云短信测试")
                .setTemplateCode("SMS_154950909")
                .setTemplateParam("{\"code\":\"" + code + "\"}");
        try {
            SendSmsResponse response = client.sendSms(smsRequest);
            System.out.println("短信发送结果:" + response.getStatusCode() +
                    "===响应码：" + response.getBody().getCode() +
                    "===响应消息：" + response.getBody().getMessage());
        } catch (Exception e) {
            System.out.println("发送短信发生错误：" + e.getMessage());
        }
    }
}
