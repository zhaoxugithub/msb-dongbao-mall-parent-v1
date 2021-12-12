package com.serendipity.dongbao.ums.entity.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: 11931
 * Date: 2021/12/11 14:38
 * FileName: UmsMemberRegisterParamDTO
 * Description: com.serendipity.dongbao.ums.entity.dto
 */
@Data
@ToString
public class UmsMemberRegisterParamDTO {
    @Size(min = 1, max = 8, message = "用户名长度在1-8之间")
    private String username;
    private String password;
    private String icon;
    @Email
    private String email;
    @NotEmpty(message = "用户昵称不能为空")
    private String nickName;
}
