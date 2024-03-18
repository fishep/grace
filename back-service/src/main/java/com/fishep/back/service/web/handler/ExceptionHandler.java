package com.fishep.back.service.web.handler;

import com.fishep.common.exception.AppException;
import com.fishep.common.type.Result;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author fly.fei
 * @Date 2024/2/28 14:49
 * @Desc
 **/
@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({AppException.class})
    public Result<Object> appException(AppException e) {
        return new Result<>(e.getCode(), e.getMessage(), e.getStackTrace());
    }

}
