package com.springbootProject.lease.web.admin.custom.interceptor;

import com.springbootProject.lease.common.login.LoginUser;
import com.springbootProject.lease.common.login.LoginUserHolder;
import com.springbootProject.lease.common.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author BobShen
 * @date 25/07/2024 00:00
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(@NotNull HttpServletRequest request,
                             @NotNull HttpServletResponse response,
                             @NotNull Object handler) throws Exception {
        // 检查token是否合法
        String token = request.getHeader("access-token");
        // 没有异常的话，放行
        Claims claims = JwtUtil.parseToken(token);
        LoginUserHolder.setLoginUser(new LoginUser(claims.get("userId", Long.class),
                claims.get("username", String.class)));
        return true;
    }

    // 释放资源
    @Override
    public void afterCompletion(@NotNull HttpServletRequest request,
                                @NotNull HttpServletResponse response,
                                @NotNull Object handler,
                                Exception ex) throws Exception {
        LoginUserHolder.clear();
    }
}
