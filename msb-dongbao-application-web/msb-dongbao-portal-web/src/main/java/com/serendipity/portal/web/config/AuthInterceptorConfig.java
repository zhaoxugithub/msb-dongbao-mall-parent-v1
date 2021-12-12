package com.serendipity.portal.web.config;

import com.serendipity.portal.web.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: 11931
 * Date: 2021/12/13 16:48
 * FileName: AuthInterceptorConfig
 * Description: com.serendipity.portal.web.config
 */
@Configuration
public class AuthInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/user-member/login")
                .excludePathPatterns("/user-member/register")
                .excludePathPatterns("/easy-captcha/**")
                .excludePathPatterns("/swagger-ui.html")
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/v2/**")
                .excludePathPatterns("/webjars/**");
    }

    // 必须要加上bean,不然spring管理不到
    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }
}
