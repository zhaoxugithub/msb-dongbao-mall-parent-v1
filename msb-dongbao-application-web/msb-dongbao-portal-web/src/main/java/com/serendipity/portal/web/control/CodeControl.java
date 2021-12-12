package com.serendipity.portal.web.control;

import com.serendipity.dongbao.common.base.annotations.TokenCheck;
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

}
