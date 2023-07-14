package com.cybersoft.osahaneat.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

// dùng component vì class này sử dụng nhiều lần
// không liên quán đến xử lí csdl

@Component
public class JwtUtilHelper {
    // lấy ra kĩ đã lưu trong yml để sử dụng

    @Value("${spring.jwt.privateKey}")
    private String privateKey;

    public String generalToken (String data){
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
        String jws = Jwts.builder().setSubject(data).signWith(key).compact();

        return jws;
    }

    public boolean verifyToken (String token){
        try {
            SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));

            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);

            return true;
        }catch (Exception e){
            return  false;
        }
    }
}
