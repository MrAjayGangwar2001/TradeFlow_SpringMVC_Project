package com.Portfolio.app.Model;

import java.util.ArrayList;
import java.util.List;

import com.Portfolio.app.Wallet.WalletModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    private String name;
    private String email;




    @ManyToMany
    @JoinTable(
    name = "UserDashboard",
    joinColumns = @JoinColumn(name = "Userid"),
    inverseJoinColumns = @JoinColumn(name = "DashboardId"))
    private List<DashboardModel> dashboard = new ArrayList<>();

    // Wallet Relation

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wallet_id", referencedColumnName = "walletId")
    private WalletModel wallet;
    
}
