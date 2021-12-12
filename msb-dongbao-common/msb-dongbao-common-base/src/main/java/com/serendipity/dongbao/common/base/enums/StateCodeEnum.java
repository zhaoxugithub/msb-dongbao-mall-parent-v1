package com.serendipity.dongbao.common.base.enums;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: 11931
 * Date: 2021/12/10 15:22
 * FileName: StateCodeEnum
 * Description: com.serendipity.dongbao.common.base.enums
 */
public enum StateCodeEnum {


    PASSWORD_ERROR(1001, "密码不正确"),
    USER_EMPTY(1003, "用户不存在"),
    FAIL(500, "请求失败"),
    SUCCESS(200, "请求成功");


    private int code;
    private String msg;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    StateCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
