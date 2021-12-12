package com.serendipity.dongbao.ums.service;

import com.serendipity.dongbao.common.base.result.ResultWrapper;
import com.serendipity.dongbao.ums.entity.UmsMember;
import com.serendipity.dongbao.ums.entity.dto.UmsMemberLoginParamDTO;
import com.serendipity.dongbao.ums.entity.dto.UmsMemberRegisterParamDTO;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author 赵旭
 * @since 2021-12-09
 */
@Service
public interface UmsMemberService {
    ResultWrapper register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO);

    ResultWrapper login(UmsMemberLoginParamDTO umsMemberLoginParamDTO);

    ResultWrapper edit(UmsMember umsMember);
}
