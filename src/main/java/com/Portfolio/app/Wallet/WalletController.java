package com.Portfolio.app.Wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class WalletController {
    
    @Autowired
    private WalletService ws;

    @PostMapping("/api/{Id}/wallet")
    public WalletDto AddMoney(@Valid @RequestBody WalletDto walletDto, @PathVariable Long Id) throws Exception{

        return ws.AddMoney(walletDto, Id);
    }


    // To Check Balance in Wallet

    @GetMapping("/api/user/{Id}/wallet")
    public WalletDto getWalletBalance(@PathVariable Long Id) throws Exception {
        return ws.getWalletBalance(Id);
    }
    
}
