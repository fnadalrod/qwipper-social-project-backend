package com.qwipper.auth.application.service;

import com.qwipper.auth.domain.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {
    //TODO A secret storage service will be used. Never store a secret key like this
    private final String SECRET_KEY = "SUPER_SECRET_KEY_SUPER_SECRET_KEY_SUPER_SECRET_KEY_SUPER_SECRET_KEY_SUPER_SECRET_KEY_SUPER_SECRET_KEY_SUPER_SECRET_KEY_SUPER_SECRET_KEY_SUPER_SECRET_KEY_SUPER_SECRET_KEY_SUPER_SECRET_KEY_SUPER_SECRET_KEY_";

    public String generateAccessToken(User user, Date now, Date expiry) {
        return Jwts.builder()
                .setSubject(user.getUsername().value())
                .setIssuedAt(now)
                .setExpiration(expiry)
                .setIssuer("qwipper-auth")
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    public String generateRefreshToken(User user, Date now, Date expiry) {
        return Jwts.builder()
                .setSubject(user.getUsername().value())
                .setIssuedAt(now)
                .setExpiration(expiry)
                .setIssuer("qwipper-auth")
                .claim("type", "refresh")
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public Map<String, Object> generateAuthData(User user) {
        Map<String, Object> tokens = new HashMap<>();

        Date now = new Date();
        Date accessTokenExpirationDate = new Date(now.getTime() + 1000 * 60 * 60 * 24);
        Date refreshTokenExpirationDate = new Date(now.getTime() + 1000L * 60 * 60 * 24 * 7);
        String accessToken = generateAccessToken(user, now, accessTokenExpirationDate);
        String refreshToken = generateRefreshToken(user, now, refreshTokenExpirationDate);

        tokens.put("accessToken", accessToken);
        tokens.put("accessTokenExpirationTime", accessTokenExpirationDate.getTime());
        tokens.put("refreshToken", refreshToken);
        tokens.put("refreshTokenExpirationTime", refreshTokenExpirationDate.getTime());

        return tokens;
    }

    public boolean isTokenValid(String token, User user) {
        String username = extractUsername(token);

        return username.equals(user.getUsername().value()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }
}
