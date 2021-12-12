package com.serendipity.dongbao.ums.service;

import com.serendipity.dongbao.common.base.enums.StateCodeEnum;
import com.serendipity.dongbao.common.base.result.ResultWrapper;
import com.serendipity.dongbao.common.util.JwtUtil;
import com.serendipity.dongbao.ums.entity.UmsMember;
import com.serendipity.dongbao.ums.entity.dto.UmsMemberLoginParamDTO;
import com.serendipity.dongbao.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.serendipity.dongbao.ums.entity.reponse.UserMemberLoginResponse;
import com.serendipity.dongbao.ums.mapper.UmsMemberMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author 赵旭
 * @since 2021-12-09
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private UmsMemberMapper umsMemberMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResultWrapper register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO) {
        UmsMember umsMember = new UmsMember();
        // 将dto 属性拷贝到umsMember
        BeanUtils.copyProperties(umsMemberRegisterParamDTO, umsMember);
        String encode = passwordEncoder.encode(umsMemberRegisterParamDTO.getPassword());
        umsMember.setPassword(encode);
        umsMemberMapper.insert(umsMember);
        return ResultWrapper.getSuccessBuilder().build();
    }

    @Override
    public ResultWrapper login(UmsMemberLoginParamDTO umsMemberLoginParamDTO) {
        System.out.println("sssss");
        UmsMember umsMember = umsMemberMapper.selectByName(umsMemberLoginParamDTO.getUsername());
        if (null != umsMember) {
            String password = umsMemberLoginParamDTO.getPassword();
            //如果验证通过
            if (!passwordEncoder.matches(password, umsMember.getPassword())) {
                return ResultWrapper.builder().code(StateCodeEnum.PASSWORD_ERROR.getCode()).msg(StateCodeEnum.PASSWORD_ERROR.getMsg()).build();
            }
        } else {
            return ResultWrapper.builder().code(StateCodeEnum.USER_EMPTY.getCode()).msg(StateCodeEnum.USER_EMPTY.getMsg()).build();
        }
        String token = JwtUtil.createToken(umsMember.getId() + "");
        UserMemberLoginResponse userMemberLoginResponse = new UserMemberLoginResponse();
        userMemberLoginResponse.setToken(token);
        umsMember.setPassword("");
        userMemberLoginResponse.setUmsMember(umsMember);
        return ResultWrapper.getSuccessBuilder().data(userMemberLoginResponse).build();
    }

    @Override
    public ResultWrapper edit(UmsMember umsMember) {
        if (umsMember == null) {
            return ResultWrapper.getFailBuilder().msg("参数对象为null").build();
        }
        umsMember.setPassword(passwordEncoder.encode(umsMember.getPassword()));
        umsMemberMapper.updateById(umsMember);
        return ResultWrapper.getSuccessBuilder().build();
    }
}
