package com.serendipity.portal.web.interceptor;

import com.serendipity.dongbao.common.base.annotations.TokenCheck;
import com.serendipity.dongbao.common.base.exception.TokenException;
import com.serendipity.dongbao.common.util.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: 11931
 * Date: 2021/12/13 16:18
 * FileName: AuthInterceptor
 * Description: com.serendipity.portal.web.interceptor
 */
//不能加RestControllerAdvice的原因是，没有办法指定拦截器拦截哪些方法，需要额外写一个拦截器配置类，专门用来配置拦截哪些方法。
//@RestControllerAdvice
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("鉴权拦截器。。。");
        String token = request.getHeader("token");
        System.out.println("token = " + token);
        if (StringUtils.isEmpty(token)) {
            throw new TokenException("token 为空");
        }
        //获取controller 方法
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        System.out.println("method = " + method);
        //判断controller方法是否添加了鉴权注解
        if (method.isAnnotationPresent(TokenCheck.class)) {
            TokenCheck annotation = method.getAnnotation(TokenCheck.class);
            // 如果必须需要鉴权
            if (annotation.required()) {
                try {
                    JwtUtil.parseToken(token);
                } catch (Exception e) {
                    throw new TokenException("Token 无效");
                }
            }
        }
        return true;
    }
}
