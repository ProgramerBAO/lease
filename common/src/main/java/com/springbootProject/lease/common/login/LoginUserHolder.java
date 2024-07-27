package com.springbootProject.lease.common.login;

public class LoginUserHolder {
    // 线程变量 LoginUser
    public static ThreadLocal<LoginUser> threadLocal = new ThreadLocal<>();

    public static void setLoginUser(LoginUser loginUser){
        threadLocal.set(loginUser);
    }
    public static LoginUser getLoginUser(){
        return threadLocal.get();
    }
    public static void clear(){
        threadLocal.remove();
    }
}
