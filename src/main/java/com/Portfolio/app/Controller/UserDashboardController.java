package com.Portfolio.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Portfolio.app.Service.UserDashboardService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/userdashboard")
public class UserDashboardController {

    @Autowired
    private UserDashboardService uds;


    @PostMapping("/{userid}/{assetid}") 
    public String UserAsset(@PathVariable("userid") Long Userid, @PathVariable("assetid") Long Assetid) throws Exception{
        return uds.UserAsset(Userid, Assetid);
    }
}
