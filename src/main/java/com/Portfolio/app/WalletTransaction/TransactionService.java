package com.Portfolio.app.WalletTransaction;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<TransactionDto> findTransactionByWalletId(Long walletId) throws Exception {

        List<TransactionModel> tm = transRepo.findByWallet_WalletId(walletId);

        if (tm.isEmpty()) {
            throw new Exception("Transaction is Empty for the wallet Id : " + walletId);
        }

        // Agar Hume sirf read-only list chahiye, to .toList() use karna best hai.

        // Agar Hume baad me list modify karni hai (add/remove/update), to
        // .collect(Collectors.toList()) use karenge.
        return tm.stream().map((trans) -> new TransactionDto(trans.getTransactionId(), trans.getAmount(),
                trans.getType(), trans.getDescription())).collect(Collectors.toList());
        // return transRepo.findByWallet_WalletId(walletId);
    }

}
