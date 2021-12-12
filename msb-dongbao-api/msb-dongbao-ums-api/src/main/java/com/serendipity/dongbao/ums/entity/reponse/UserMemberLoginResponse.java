package com.serendipity.dongbao.ums.entity.reponse;

import com.serendipity.dongbao.ums.entity.UmsMember;
import lombok.Data;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: 11931
 * Date: 2021/12/12 0:43
 * FileName: UserMemberLoginResponse
 * Description: com.serendipity.dongbao.ums.entity.reponse
 */
@Data
public class UserMemberLoginResponse {
    private String token;
    private UmsMember umsMember;
}
