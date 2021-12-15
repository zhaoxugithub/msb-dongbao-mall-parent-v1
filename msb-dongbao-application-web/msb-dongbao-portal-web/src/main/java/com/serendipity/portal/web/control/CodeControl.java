package com.serendipity.portal.web.control;

import com.ramostear.captcha.HappyCaptcha;
import com.serendipity.dongbao.common.base.annotations.TokenCheck;
import com.serendipity.dongbao.common.base.result.ResultWrapper;
import com.wf.captcha.ChineseCaptcha;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: 11931
 * Date: 2021/12/15 0:17
 * FileName: codeControl
 * Description: com.serendipity.portal.web.control
 */
@RestController
@RequestMapping("/easy-captcha")
public class CodeControl {

    @TokenCheck(required = false)
    @GetMapping("/generator")
    public void generatorCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ChineseCaptcha chineseCaptcha = new ChineseCaptcha(150, 50);
        CaptchaUtil.out(chineseCaptcha, request, response);
    }

    @GetMapping("/verifyCode")
    public ResultWrapper verifyCode(String code, HttpServletRequest request) {
        if (CaptchaUtil.ver(code, request)) {
            // 验证成功过之后一定要remove掉
            HappyCaptcha.remove(request);
            return ResultWrapper.getSuccessBuilder().msg("验证成功").build();
        }
        return ResultWrapper.getFailBuilder().msg("验证失败").build();
    }

    @GetMapping("/generateRedisCode")
    public void generateRedisCode() {

    }

    @RequestMapping("/verifyRedisCode")
    public ResultWrapper verifyCode() {
        return null;
    }

}
