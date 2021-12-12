package com.serendipity.dongbao.common.base.result;

import com.serendipity.dongbao.common.base.enums.StateCodeEnum;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: 11931
 * Date: 2021/12/10 14:59
 * FileName: ResultWrapper
 * Description: com.serendipity.dongbao.common.base.result
 */
@Data
@Builder
public class ResultWrapper<T> implements Serializable {

    private int code;

    private String msg;

    private T data;

    // 这里用到了建造者模式
    public static ResultWrapper.ResultWrapperBuilder getSuccessBuilder() {
        return ResultWrapper.builder().code(StateCodeEnum.SUCCESS.getCode()).msg(StateCodeEnum.SUCCESS.getMsg());
    }

    public static ResultWrapper.ResultWrapperBuilder getFailBuilder() {
        return ResultWrapper.builder().code(StateCodeEnum.FAIL.getCode()).msg(StateCodeEnum.FAIL.getMsg());
    }
}
