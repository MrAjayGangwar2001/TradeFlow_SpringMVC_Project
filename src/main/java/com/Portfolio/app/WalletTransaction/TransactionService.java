package com.Portfolio.app.WalletTransaction;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Portfolio.app.Enum.TransactionType;
import com.Portfolio.app.Wallet.WalletModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transRepo;

    public void RecordTransaction(WalletModel wm, Double amount, TransactionType Deposit, String desc) {

        TransactionModel tm = new TransactionModel();
        tm.setWallet(wm);
        tm.setAmount(amount);
        // tm.setType(TransactionType.Deposit);
        tm.setType(Deposit);
        tm.setDescription(desc);

        transRepo.save(tm);

    }

    public List<TransactionDto> GetTransactionByWalletId(Long walletId) {

        return transRepo.findByWallet_WalletId(walletId);
    }

}
