package com.serendipity.portal;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: 11931
 * Date: 2021/12/11 21:21
 * FileName: web
 * Description: com.serendipity.portal
 */
public class EncodeTest {


    // MD5 加密只要输入是固定的,则输出就一定是固定的
    @Test
    public void testMD5() {

        String str1 = "123456";
        String s1 = DigestUtils.md5DigestAsHex(str1.getBytes());
        System.out.println("第一次加密：" + s1);
        String s2 = DigestUtils.md5DigestAsHex(str1.getBytes());
        System.out.println("第二次加密：" + s2);
    }

    @Test
    public void BcryptTest() {
        String str1 = "123456";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode1 = bCryptPasswordEncoder.encode(str1);
        String encode2 = bCryptPasswordEncoder.encode(str1);
        System.out.println("第一次加密：" + encode1 + "\n" + "第二次加密：" + encode2);
        //验证输入加密的之后肊加密之后的字符是否相等
        boolean matches = bCryptPasswordEncoder.matches(str1, encode1);
        boolean matches1 = bCryptPasswordEncoder.matches(str1, encode2);
        System.out.println(matches+"::"+matches1);
    }
}
