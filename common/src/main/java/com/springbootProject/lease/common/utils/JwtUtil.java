package com.springbootProject.lease.common.utils;


import com.springbootProject.lease.common.exception.LeaseException;
import com.springbootProject.lease.common.result.ResultCodeEnum;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;


import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {

    private static final SecretKey secretKey = Keys.hmacShaKeyFor("CvFcNErQxSRravVUFv1BeIog0CMUESD4".getBytes());


    public static String createToken(Long userId, String userName) {
        long tokenExpiration = 60 * 60 * 1000L;
        return Jwts.builder()
                .setSubject("LOGIN_USER")
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .claim("userId", userId)
                .claim("username", userName)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public static Claims parseToken(String token) {
        // token为空表示未登录
        if (token == null) {
            throw new LeaseException(ResultCodeEnum.ADMIN_LOGIN_AUTH);
        }

        try {
            return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            throw new LeaseException(ResultCodeEnum.TOKEN_EXPIRED);
        } catch (JwtException e) {
            throw new LeaseException(ResultCodeEnum.TOKEN_INVALID);
        }

    }

    public static void main(String[] args) {
        System.out.println(createToken(2L, "user"));
        System.out.println(parseToken(createToken(2L, "user")));
    }
}
