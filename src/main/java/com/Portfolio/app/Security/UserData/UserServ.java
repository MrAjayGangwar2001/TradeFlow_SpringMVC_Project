package com.Portfolio.app.Security.UserData;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServ {

    private final UserReposit urepo;
    private final  PasswordEncoder passEncode;

    public String CreateUser(User user) {

        user.setPassword(passEncode.encode(user.getPassword()));

        urepo.save(user);

        return "Data has been Successfully Sent";

    }

}
