package com.test.springwebflux.jwt.util;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    // JWT Token 을 생성하고 검증
    private final String secret = "secret"; // JWT Secret Key
    private final long validityInMilliseconds = 36000000;   //  1 hour

    public String createToken(String userName) {
        Date now = new Date();
        Date validity = new Date(now.getTime());

        // JWT Token 을 생성
        return Jwts.builder()
                .setSubject(userName)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String getUserNameFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch(JwtException | IllegalArgumentException e) {
            return false;
        }
    }

}
