package com.springbootProject.lease.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import com.springbootProject.lease.common.result.ResultCodeEnum;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class LeaseException extends RuntimeException{
    //异常状态码
    private Integer code;

    // 构造方法
    public LeaseException(String message,Integer code) {
        super(message);
        this.code=code;
    }
    // 构造方法 从ResultCodeEnum中获取异常信息
    public LeaseException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code=resultCodeEnum.getCode();
    }
}
