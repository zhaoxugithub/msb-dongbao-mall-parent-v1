package com.serendipity.portal.web.control;

import com.serendipity.dongbao.common.base.annotations.TokenCheck;
import com.serendipity.dongbao.common.base.result.ResultWrapper;
import com.serendipity.dongbao.common.util.JwtUtil;
import com.serendipity.dongbao.ums.entity.UmsMember;
import com.serendipity.dongbao.ums.entity.dto.UmsMemberLoginParamDTO;
import com.serendipity.dongbao.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.serendipity.dongbao.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: 11931
 * Date: 2021/12/10 19:55
 * FileName: UmsMemberService
 * Description: com.serendipity.portal.web.control
 */

/*
@ResponseBody是作用在方法上的，@ResponseBody 表示该方法的返回结果直接写入 HTTP response body 中，
一般在异步获取数据时使用【也就是AJAX】，在使用 @RequestMapping后，返回值通常解析为跳转路径，
但是加上 @ResponseBody 后返回结果不会被解析为跳转路径，而是直接写入 HTTP response body 中。
比如异步获取 json 数据，加上 @ResponseBody 后，会直接返回 json 数据

 @RequestBody是作用在形参列表上，用于将前台发送过来固定格式的数据【xml 格式或者 json等】封装为对应的 JavaBean 对象，
 封装时使用到的一个对象是系统默认配置的 HttpMessageConverter进行解析，然后封装到形参上。


 */
@RestController
@RequestMapping("/user-member")
public class UmsMemberControl {

    @Autowired
    private UmsMemberService umsMemberService;

    @PostMapping(value = "/register")
    public ResultWrapper register(@RequestBody @Valid UmsMemberRegisterParamDTO umsMemberRegisterParamDTO) {
        return umsMemberService.register(umsMemberRegisterParamDTO);
    }

    @PostMapping("/login")
    public ResultWrapper login(@RequestBody UmsMemberLoginParamDTO umsMemberLoginParamDTO) {
        return umsMemberService.login(umsMemberLoginParamDTO);
    }

    @TokenCheck
    @PostMapping("/edit")
    public ResultWrapper edit(@RequestBody UmsMember umsMember) {
        return umsMemberService.edit(umsMember);
    }

    @GetMapping("/verify_token")
    public String verifyToken(String token) {
        return JwtUtil.parseToken(token);
    }


    @GetMapping("/remove")
    public ResultWrapper remove(Integer id) {
        return umsMemberService.remove(id);
    }
}
