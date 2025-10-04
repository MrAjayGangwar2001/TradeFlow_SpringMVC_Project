package com.Portfolio.app.Wallet;

import java.util.HashSet;
import java.util.Set;

import com.Portfolio.app.Model.UserModel;
import com.Portfolio.app.Order.OrderModel;
import com.Portfolio.app.WalletTransaction.TransactionModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "UserWallet")
public class WalletModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long walletId;

    private Double balance;

    // One To One Wallet To User Relation

    @OneToOne(mappedBy = "wallet")
    private UserModel user;

    // Wallet relation to Order
    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderModel> userOrder = new HashSet<>();

    // Wallet Relation To Transaction
    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TransactionModel> transaction = new HashSet<>();

}
