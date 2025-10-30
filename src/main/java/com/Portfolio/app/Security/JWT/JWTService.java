package com.Portfolio.app.Security.JWT;
import com.Portfolio.app.Security.UserData.User;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {

    private final String jwtSecretKey = "fkfemfrjfbdwebudywefcbweicibjwebvii";

    // STEP : 1 => ENCODE SECRET KEY
    private SecretKey EncodeSecretKey(){

        return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
    }

    // STEP : 2 => CREATE TOKEN KEY

    
    public String CreateToken(User user){


        return Jwts.builder().subject(user.getUserId().toString())
        .claim("email", user.getEmail()).issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis() + 1000 * 60)).signWith(EncodeSecretKey()).compact();
    }
}
