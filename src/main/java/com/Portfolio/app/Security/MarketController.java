package com.Portfolio.app.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/market")
public class MarketController {

    @Autowired
    private MarketService marketService;

    @GetMapping("/quote")
    public String getPrice(@RequestParam String instrument) {
        String token = "eyJ0eXAiOiJKV1QiLCJrZXlfaWQiOiJza192MS4wIiwiYWxnIjoiSFMyNTYifQ.eyJzdWIiOiI0RkJCWTMiLCJqdGkiOiI2OTAzMGMyZDJmYTI3MDc1MTQwNDM2ZDciLCJpc011bHRpQ2xpZW50IjpmYWxzZSwiaXNQbHVzUGxhbiI6ZmFsc2UsImlhdCI6MTc2MTgwNzQwNSwiaXNzIjoidWRhcGktZ2F0ZXdheS1zZXJ2aWNlIiwiZXhwIjoxNzYxODYxNjAwfQ.5ZYavZL3Nm9ADwdLiEGclA7ZFYN5L6dxO59DNSerdwk"; // replace
        return marketService.getQuote(instrument, token);
    }

    @GetMapping("/test")
    public String test() {
        return "OK";
    }

}
