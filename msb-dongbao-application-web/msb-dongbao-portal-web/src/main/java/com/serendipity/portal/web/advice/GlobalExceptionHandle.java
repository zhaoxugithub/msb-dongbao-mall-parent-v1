package com.serendipity.portal.web.advice;

import com.serendipity.dongbao.common.base.exception.LoginException;
import com.serendipity.dongbao.common.base.exception.TokenException;
import com.serendipity.dongbao.common.base.result.ResultWrapper;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: 11931
 * Date: 2021/12/12 2:20
 * FileName: GlobalExceptionHandle
 * Description: com.serendipity.portal.web.advice
 */

//RestControllerAdvice = ControllerAdvice + ResponseBody
@RestControllerAdvice
public class GlobalExceptionHandle {

    // 这里的异常要和实际的对应上才会执行
//    @ExceptionHandler(Exception.class)
//    public ResultWrapper customException() {
//        return ResultWrapper.builder().code(301).msg("统一异常").build();
//    }

    @ExceptionHandler(TokenException.class)
    public ResultWrapper tokenException(Exception e) {
        return ResultWrapper.builder().code(301).msg(e.getMessage()).build();
    }

    @ExceptionHandler(LoginException.class)
    public ResultWrapper loginException() {
        return ResultWrapper.builder().code(301).msg("登录异常").build();
    }
}
