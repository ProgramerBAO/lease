package com.springbootProject.lease.web.admin.service.impl;

import com.springbootProject.lease.common.constant.RedisConstant;
import com.springbootProject.lease.common.exception.LeaseException;
import com.springbootProject.lease.common.result.ResultCodeEnum;
import com.springbootProject.lease.common.utils.JwtUtil;
import com.springbootProject.lease.model.entity.SystemUser;
import com.springbootProject.lease.model.enums.BaseStatus;
import com.springbootProject.lease.web.admin.mapper.SystemUserMapper;
import com.springbootProject.lease.web.admin.service.LoginService;
import com.springbootProject.lease.web.admin.vo.login.CaptchaVo;
import com.springbootProject.lease.web.admin.vo.login.LoginVo;
import com.springbootProject.lease.web.admin.vo.systemUser.SystemUserInfoVo;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import jakarta.annotation.Resource;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private SystemUserMapper systemUserMapper;
    @Override
    public CaptchaVo getCaptcha() {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 40,3);
        specCaptcha.setCharType(Captcha.TYPE_DEFAULT);
        String code = specCaptcha.text().toLowerCase();
        String key=RedisConstant.ADMIN_LOGIN_PREFIX+ UUID.randomUUID();
        String image = specCaptcha.toBase64();
        stringRedisTemplate.opsForValue().set(key,code,RedisConstant.ADMIN_LOGIN_CAPTCHA_TTL_SEC, TimeUnit.SECONDS);
        System.out.println("redis存储key:"+stringRedisTemplate.opsForValue().get(key));
        return new CaptchaVo(image,key);
    }

    @Override
    public String login(LoginVo loginVo) {
        // 判断`captchaCode`是否为空，若为空，则直接响应`验证码为空`；若不为空进行下一步判断。
        if(!StringUtils.hasText(loginVo.getCaptchaCode())){
            throw new LeaseException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_NOT_FOUND);
        }
        String captchaKey = loginVo.getCaptchaKey();
        System.out.println("key:"+captchaKey);
        String value = stringRedisTemplate.opsForValue().get(captchaKey);
        System.out.println("redis存储的值："+value);
        //根据`captchaKey`从Redis中查询之前保存的`code`，若查询出来的`code`为空，则直接响应`验证码已过期`；若不为空进行下一步判断。
        if(value==null){
            throw new LeaseException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_EXPIRED);
        }
        ///- 比较`captchaCode`和`code`，若不相同，则直接响应`验证码不正确`；若相同则进行下一步判断。
        if(!value.equals(loginVo.getCaptchaCode().toLowerCase())){
            throw new LeaseException(ResultCodeEnum.APP_LOGIN_CODE_ERROR);
        }
        //- 根据`username`查询数据库，若查询结果为空，则直接响应`账号不存在`；若不为空则进行下一步判断。

        SystemUser systemUser = systemUserMapper.selectOneByUsername(loginVo.getUsename());

        if(systemUser==null){
            throw new LeaseException(ResultCodeEnum.ADMIN_ACCOUNT_NOT_EXIST_ERROR);
        }
        //- 查看用户状态，判断是否被禁用，若禁用，则直接响应`账号被禁`；若未被禁用，则进行下一步判断。
        if(systemUser.getStatus()== BaseStatus.ENABLE){
            throw new LeaseException(ResultCodeEnum.ADMIN_ACCOUNT_DISABLED_ERROR);
        }

        //- 比对`password`和数据库中查询的密码，若不一致，则直接响应`账号或密码错误`，若一致则进行入最后一步。

        if(!systemUser.getPassword().equals(DigestUtils.md5Hex(loginVo.getPassword())) ){
            throw new LeaseException(ResultCodeEnum.ADMIN_ACCOUNT_ERROR);
        }
        //创建JWT，并响应给浏览器。

        return JwtUtil.createToken(systemUser.getId(), systemUser.getUsername());
    }

    @Override
    public SystemUserInfoVo getLoginUserInfoById(Long userId) {

        SystemUser systemUser = systemUserMapper.selectById(userId);

        SystemUserInfoVo systemUserInfoVo = new SystemUserInfoVo();
        systemUserInfoVo.setName(systemUser.getName());
        systemUserInfoVo.setAvatarUrl(systemUser.getAvatarUrl());
        return systemUserInfoVo;
    }
}
