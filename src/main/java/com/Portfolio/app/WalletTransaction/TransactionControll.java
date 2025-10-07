package com.Portfolio.app.WalletTransaction;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TransactionControll {

    private final TransactionService transactionService;

    @GetMapping("/wallet/{walletId}")
    public List<TransactionDto> findTransactionByWalletId(@PathVariable Long walletId) throws Exception{
        return transactionService.findTransactionByWalletId(walletId);
    }
}
