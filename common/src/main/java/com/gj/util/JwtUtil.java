package com.gj.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.bouncycastle.util.encoders.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

/**
 * @ClassName: JwtUtil
 * @Description:  生成token，校验token
 * @Author: 赵云
 * @Date: 2020/5/22 14:41
 * @Version: V1.0
 **/

public class JwtUtil {

    private static final String JWT_SECRET = "gj123456";

    private JwtUtil(){}

    public static String createJwt(String id,String subject,long ttMillis){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        SecretKey secretKey = generalKye();
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setSubject(subject)
                .setIssuer("user")
                .setIssuedAt(now)

                // 也可以自定义字段
                .claim("userId","123456")
                .claim("age",18)

                .signWith(signatureAlgorithm, secretKey);

        // 不设置过期时间： 实际业务中，可以在redis中设置过期时间
        if (ttMillis>= 0 ){
            long expMillis = nowMillis + ttMillis;
            Date expDate = new Date(expMillis);
            //builder.setExpiration(expDate);
        }
        return builder.compact();
    }


    public static Claims parseJwt(String jwt){
        SecretKey secretKey = generalKye();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }

    private static SecretKey generalKye() {
        byte[] bytes = Base64.decode(JWT_SECRET);
        SecretKeySpec key = new SecretKeySpec(bytes, "AES");
        return key;
    }

    public static void main(String[] args) {

        String jwt = JwtUtil.createJwt("1", "ss", 10000);
        System.out.println(jwt);

        // 解析---------------
        Claims claims1 = parseJwt(jwt);

        System.out.println(claims1);
    }
}
