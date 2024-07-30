package com.springbootProject.lease.web.app.service.impl;

import com.springbootProject.lease.web.app.service.SmsService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author BobShen
 * @date 30/07/2024 01:13
 */
@SpringBootTest
class SmsServiceImplTest {
    @Resource
    private SmsService smsService;

    @Test
    void sendCode() {
        smsService.sendCode("17395711520", "123456");
    }
}