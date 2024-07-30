package com.springbootProject.lease.web.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.springbootProject.lease.common.constant.RedisConstant;
import com.springbootProject.lease.common.exception.LeaseException;
import com.springbootProject.lease.common.result.ResultCodeEnum;
import com.springbootProject.lease.common.utils.CodeUtil;
import com.springbootProject.lease.common.utils.JwtUtil;
import com.springbootProject.lease.model.entity.UserInfo;
import com.springbootProject.lease.model.enums.BaseStatus;
import com.springbootProject.lease.web.app.mapper.UserInfoMapper;
import com.springbootProject.lease.web.app.service.LoginService;
import com.springbootProject.lease.web.app.service.SmsService;
import com.springbootProject.lease.web.app.service.UserInfoService;
import com.springbootProject.lease.web.app.vo.LoginVo;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private SmsService smsService;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private UserInfoService userInfoService;

    @Override
    public void getCode(String phone) {
        ////////////////控制验证码发送频率//////////////////

        //1. 检查手机号码是否为空
        if(!StringUtils.hasText(phone)){
            throw new LeaseException(ResultCodeEnum.APP_LOGIN_PHONE_EMPTY);
        }
        //2. 检查Redis中是否已经存在该手机号码的key
        Boolean hasKey = redisTemplate.hasKey(RedisConstant.APP_LOGIN_PREFIX + phone);
        if(Boolean.TRUE.equals(hasKey)){
            // 2.1//若存在，则检查其存在的时间
            Long expire = redisTemplate.getExpire(RedisConstant.APP_LOGIN_PREFIX + phone, TimeUnit.SECONDS);
            if(RedisConstant.APP_LOGIN_CODE_TTL_SEC - expire < RedisConstant.APP_LOGIN_CODE_RESEND_TIME_SEC){
                // 2.2//若存在时间不足一分钟，响应发送过于频繁
                throw new LeaseException(ResultCodeEnum.APP_SEND_SMS_TOO_OFTEN);
            }
        }

        //3.发送短信，并将验证码存入Redis设置规律的key ttl
        String code = CodeUtil.getRandomCode(6);
        //smsService.sendCode(phone,code);
        System.out.println("短信验证码："+code);
        redisTemplate.opsForValue().set(RedisConstant.APP_LOGIN_PREFIX+phone,code,RedisConstant.APP_LOGIN_CODE_TTL_SEC,TimeUnit.SECONDS);

    }

    @Override
    public String login(LoginVo loginVo) {
        ///生成token
        //1.判断手机号码不空
        if(!StringUtils.hasText(loginVo.getPhone())){
            throw new LeaseException(ResultCodeEnum.APP_LOGIN_PHONE_EMPTY);
        }
        if(!StringUtils.hasText(loginVo.getCode())){
            throw new LeaseException(ResultCodeEnum.APP_LOGIN_CODE_EMPTY);
        }

        //查询短信验证码
        Object code = redisTemplate.opsForValue().get(RedisConstant.APP_LOGIN_PREFIX + loginVo.getPhone());
        if(code==null){
            throw new LeaseException(ResultCodeEnum.APP_LOGIN_CODE_EXPIRED);
        }
        System.out.println("redis:"+code);
        System.out.println("输入："+loginVo.getCode());
        System.out.println(code==loginVo.getCode());
        if(!code.equals(loginVo.getCode())){
            throw new LeaseException(ResultCodeEnum.APP_LOGIN_CODE_ERROR);
        }

        ////3.判断用户是否存在,不存在则注册（创建用户）

        LambdaQueryWrapper<UserInfo> userInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userInfoLambdaQueryWrapper.eq(UserInfo::getPhone,loginVo.getPhone());
        UserInfo userInfo = userInfoMapper.selectOne(userInfoLambdaQueryWrapper);

        if(userInfo==null){
            userInfo = new UserInfo();
            userInfo.setPhone(loginVo.getPhone());
            userInfo.setStatus(BaseStatus.ENABLE);
            userInfo.setNickname("用户-"+loginVo.getPhone().substring(5));
            userInfoMapper.insert(userInfo);
            System.out.println("插入数据记录的主键："+userInfo.getId());

        }else{
            //4.判断用户是否被禁
            if(userInfo.getStatus().equals(BaseStatus.ENABLE)){
                throw new LeaseException(ResultCodeEnum.ADMIN_ACCOUNT_DISABLED_ERROR);
            }

        }
        //5.创建并返回TOKEN
        return JwtUtil.createToken(userInfo.getId(),userInfo.getPhone());

    }
}
