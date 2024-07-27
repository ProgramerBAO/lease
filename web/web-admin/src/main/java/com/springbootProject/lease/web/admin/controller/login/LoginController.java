package com.springbootProject.lease.web.admin.controller.login;

import com.springbootProject.lease.common.login.LoginUserHolder;
import com.springbootProject.lease.common.result.Result;
import com.springbootProject.lease.web.admin.service.LoginService;
import com.springbootProject.lease.web.admin.vo.login.CaptchaVo;
import com.springbootProject.lease.web.admin.vo.login.LoginVo;
import com.springbootProject.lease.web.admin.vo.systemUser.SystemUserInfoVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;



@Tag(name = "后台管理系统登录管理")
@RestController
@RequestMapping("/admin")
public class LoginController {

    @Resource
    private LoginService loginService;

    @Operation(summary = "获取图形验证码")
    @GetMapping("/login/captcha")
    public Result<CaptchaVo> getCaptcha(){
        CaptchaVo captcha=loginService.getCaptcha();
        return Result.ok(captcha);
    }

    @Operation(summary = "登录接口")
    @PostMapping("login")
    public Result<String> login(@RequestBody LoginVo loginVo){
        System.out.println("loginVo:"+loginVo);
        String token=loginService.login(loginVo);
        return Result.ok(token);
    }

    @Operation(summary = "获取登录用户详细信息")
    @GetMapping("info")
    public Result<SystemUserInfoVo> info(){
        // 获取当前登录用户id
        Long userId = LoginUserHolder.getLoginUser().getUserId();
        SystemUserInfoVo userInfo=loginService.getLoginUserInfoById(userId);
        return Result.ok(userInfo);
    }
}
