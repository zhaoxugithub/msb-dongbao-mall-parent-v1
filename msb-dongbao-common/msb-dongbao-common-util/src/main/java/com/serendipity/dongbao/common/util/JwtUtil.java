package com.serendipity.dongbao.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: 11931
 * Date: 2021/12/12 0:21
 * FileName: util
 * Description: com.serendipity.dongbao.common
 */
public class JwtUtil {

    private static final String secret = "token";

    /**
     * 创建一个token
     *
     * @param subject
     * @return
     */
    public static String createToken(String subject) {
        String token = Jwts.builder().setSubject(subject).setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
        return token;
    }

    /**
     * 解析token
     *
     * @return
     */
    public static String parseToken(String token) {
        Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        String subject = body.getSubject();
        return subject;
    }

    public static void main(String[] args) throws InterruptedException {
        String token = createToken("subject");
        System.out.println(token);
        Thread.sleep(4 * 1000);
        String s = parseToken(token);
        System.out.println(s);
    }
}
