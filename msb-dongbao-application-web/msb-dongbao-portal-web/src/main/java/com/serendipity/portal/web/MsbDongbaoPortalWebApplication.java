package com.serendipity.portal.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: 11931
 * Date: 2021/12/10 20:11
 * FileName: MsbDongbaoPortalWebApplication
 * Description: com.serendipity.portal.web
 */
@SpringBootApplication(scanBasePackages = {"com.serendipity"})
@MapperScan("com.serendipity.dongbao.ums.mapper")
public class MsbDongbaoPortalWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsbDongbaoPortalWebApplication.class, args);
    }
}
