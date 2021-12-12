package com.serendipity.portal.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: 11931
 * Date: 2021/12/12 14:26
 * FileName: Swagger2Config
 * Description: com.serendipity.portal.web.config
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).
                select().apis(RequestHandlerSelectors.basePackage("com.serendipity.portal.web.control")).paths(PathSelectors.any())
                .build();


    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Swagger UI演示").description("dong-bao").contact("concat").version("1.0").build();
    }

}
