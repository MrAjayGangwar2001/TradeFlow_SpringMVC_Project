package com.Portfolio.app.WalletTransaction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionModel, Long> {

    public List<TransactionModel> findByWallet_WalletId(Long walletId);
}
