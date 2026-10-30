package com.example.utils;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.CompressionCodecs;
import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "jwt.token")
public class JwtHelper {

    // Token expiration time in milliseconds
    private long tokenExpiration;

    // Secret key used to sign the token
    private String tokenSignKey;

    // Generate a JWT token
    public String createToken(Long userId) {

        System.out.println("tokenExpiration = " + tokenExpiration);
        System.out.println("tokenSignKey = " + tokenSignKey);

        String token = Jwts.builder()
                .setSubject("YYGH-USER")
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .claim("userId", userId)
                .signWith(SignatureAlgorithm.HS512, tokenSignKey)
                .compressWith(CompressionCodecs.GZIP)
                .compact();

        return token;
    }

    // Extract user ID from the token
    public Long getUserId(String token) {

        if (StringUtils.isEmpty(token)) {
            return null;
        }

        Claims claims = Jwts.parser()
                .setSigningKey(tokenSignKey)
                .parseClaimsJws(token)
                .getBody();

        Integer userId = (Integer) claims.get("userId");

        return userId.longValue();
    }

    // Check whether the token is expired or invalid
    public boolean isExpiration(String token) {

        try {
            boolean isExpire = Jwts.parser()
                    .setSigningKey(tokenSignKey)
                    .parseClaimsJws(token)
                    .getBody()
                    .getExpiration()
                    .before(new Date());

            // Return false if the token is valid
            return isExpire;

        } catch (Exception e) {
            // Return true if an exception occurs
            return true;
        }
    }
}