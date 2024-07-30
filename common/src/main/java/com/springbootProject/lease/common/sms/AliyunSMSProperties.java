package com.springbootProject.lease.common.sms;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author BobShen
 * @date 30/07/2024 00:57
 */
@ConfigurationProperties(prefix = "aliyun.sms")
@Data
public class AliyunSMSProperties {
    private String accessKeyId;
    private String accessKeySecret;
    private String endpoint;
}
