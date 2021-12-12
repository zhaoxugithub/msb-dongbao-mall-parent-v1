package com.serendipity.dongbao.common.base.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: 11931
 * Date: 2021/12/13 13:38
 * FileName: TokenCheck
 * Description: com.serendipity.dongbao.common.base.annotations
 */
//作用在方法上
@Target(ElementType.METHOD)
//执行的时候生效
@Retention(RetentionPolicy.RUNTIME)
public @interface TokenCheck {
    boolean required() default true;
}
