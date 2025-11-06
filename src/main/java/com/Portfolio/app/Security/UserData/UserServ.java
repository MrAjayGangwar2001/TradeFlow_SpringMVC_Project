package com.Portfolio.app.Security.UserData;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Portfolio.app.Security.JWT.JWTService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServ {

    private final UserReposit urepo;
    private final PasswordEncoder passEncode;
    private final JWTService JService;

    public String CreateUser(User user) {

        user.setPassword(passEncode.encode(user.getPassword()));

        urepo.save(user);

        String token = JService.CreateToken(user);
        // String getPayLoad = JService.fetchbyId(token);
        String getPayLoad = JService.FetchEmail(token);

        // return "Token : "+ token + "\n"+ "Fetch by user id "+ getPayLoad;
        return "Token : " + token + "\n" + "Fetch by email id " + getPayLoad;
        
    }
    


}
