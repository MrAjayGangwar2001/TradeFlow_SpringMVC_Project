package com.Portfolio.app.Security.JWT;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Portfolio.app.Security.UserData.User;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class JWTController {

    private final JWTService service;

    @PostMapping("/token")
    public String postUser(@RequestBody User user) {
       
        return service.CreateToken(user);
    }

    @GetMapping("/msg")
    public String getMessage() {
        return "Hey ! This JWT Controller is working fine";
    }

    @GetMapping("/token")
    public String getMethodName() {
        User user = new User(101L,"ajay@121gmail.com",  "ajay", "ajay1234");
        // User user = new User(101, "ajay@121gmail.com", "ajay", "ajay1234");
        return service.CreateToken(user);
    }
    
    
}
