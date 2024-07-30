package com.springbootProject.lease.web.app.controller.login;

import com.springbootProject.lease.common.result.Result;
import com.springbootProject.lease.web.app.service.LoginService;
import com.springbootProject.lease.web.app.service.SmsService;
import com.springbootProject.lease.web.app.service.UserInfoService;
import com.springbootProject.lease.web.app.vo.LoginVo;
import com.springbootProject.lease.web.app.vo.user.UserInfoVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@Tag(name = "登录管理")
@RestController
@RequestMapping("/app")
public class LoginController {
    @Resource
    private LoginService loginService;
    @Resource
    private SmsService smsService;
    @Resource
    private UserInfoService userInfoService;

    @Operation(summary = "获取短信验证码")
    @GetMapping("/login/getCode")
    public Result getCode(@RequestParam String phone){
        loginService.getCode(phone);
        return Result.ok();
    }

    @Operation(summary = "登录")
    @PostMapping("/login")
    public Result<String> login(@RequestBody LoginVo loginVo){
        String token=loginService.login(loginVo);
        return Result.ok(token);
    }

    @Operation(summary = "获取登录用户信息")
    @GetMapping("info")
    public Result<UserInfoVo> info(){
        UserInfoVo userInfoVo=userInfoService.getUserInfoById();
        return Result.ok(userInfoVo);
    }
}
