package com.Portfolio.app.Security.UserData;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Portfolio.app.Security.JWT.JWTService;


@Service
public class LoginServ {

    @Autowired
    private UserReposit userRepo;
    @Autowired
    private PasswordEncoder passEncode;
    @Autowired
    private JWTService JService;



        public String LoginUser(LoginDto login) {
        
        Optional<User> user = userRepo.findByEmail(login.getEmail());
        
        if (user.isPresent()) {
            User us = user.get();
            
            if (!passEncode.matches(login.getPassword(), us.getPassword())) {
                
                String token = JService.CreateToken(us);
                String getPayLoad = JService.FetchEmail(token);
                return "Token : " + token + "\n" + "Fetch by email id " + getPayLoad;
            }
        }
        return "Your Password is Invalid";
    }
}
