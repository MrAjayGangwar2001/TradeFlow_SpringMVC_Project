package com.Portfolio.app.Model;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.Portfolio.app.Order.OrderModel;
import com.Portfolio.app.Portfolio.PortfolioModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dashboard")
public class DashboardModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    
    private String assetName;

    // private Double quantity;

    private Double price;
    
    @Column(nullable = false, updatable = false)
    // private LocalDateTime createdAt;
    private OffsetDateTime createdAt;
    
    @Column(nullable = false)
    // private LocalDateTime updatedAt;
    private OffsetDateTime updatedAt;

    //Auto Set
    @PrePersist
    protected void onCreate(){
        // this.createdAt = LocalDateTime.now();
        this.createdAt = OffsetDateTime.now();
        this.updatedAt = OffsetDateTime.now();
    }

    // Auto update
    @PreUpdate
    protected void onUpdate(){
        // this.updatedAt = LocalDateTime.now();
        this.updatedAt = OffsetDateTime.now();
    }



    // Relation To Users
    @ManyToMany(mappedBy = "dashboard")
    private List<UserModel> users;


    // Relation To Orders
    @OneToMany(mappedBy = "dashboard")
    private Set<OrderModel> ordersId;

    // Relation To Portfolio
    @OneToMany
    @JsonIgnore
    private Set<PortfolioModel> portfolio = new HashSet<>();
}
