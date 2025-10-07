package com.Portfolio.app.Order;

import com.Portfolio.app.Model.DashboardModel;
import com.Portfolio.app.Wallet.WalletModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

import com.Portfolio.app.Enum.OrderType;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Orders")
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    // { ...These assetname and price will use from dashboard Entity which is
    // already defined
    // private String assetname;
    // private Double price; }
    private String assetName;

    @Enumerated(EnumType.STRING)
    private OrderType orderType;
    private Long assetQuantity;
    private String status;

    @ManyToOne
    @JoinColumn(name = "WalletId", referencedColumnName = "walletId")
    @JsonIgnore
    private WalletModel wallet;

    // Dashboard Relationship to get data

    @ManyToOne
    @JoinColumn(name = "assetId")
    @JsonIgnore
    private DashboardModel dashboard;

    @Column(nullable = false, updatable = false)
    // private LocalDateTime createdAt;
    private OffsetDateTime createdAt;

    @Column(nullable = false)
    // private LocalDateTime updatedAt;
    private OffsetDateTime updatedAt;

    // Auto Set
    @PrePersist
    protected void onCreate() {
        // this.createdAt = LocalDateTime.now();
        this.createdAt = OffsetDateTime.now();
        this.updatedAt = OffsetDateTime.now();
    }

    // Auto update
    @PreUpdate
    protected void onUpdate() {
        // this.updatedAt = LocalDateTime.now();
        this.updatedAt = OffsetDateTime.now();
    }
}
