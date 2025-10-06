package com.Portfolio.app.WalletTransaction;

import com.Portfolio.app.Enum.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {

    private Long transactionId;
    private Double amount;

    private TransactionType type;
    private String description;
}
