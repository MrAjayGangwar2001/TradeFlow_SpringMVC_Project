package com.Portfolio.app.Portfolio;

import java.time.OffsetDateTime;

import com.Portfolio.app.Model.DashboardModel;
import com.Portfolio.app.Model.UserModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Portfolio")
public class PortfolioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;
    private Double totalQuantity;
    private Double avgBuyPrice;


    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

    @PrePersist
    protected void createdAt(){
        this.lastUpdated = OffsetDateTime.now();
    }

    @PreUpdate
    protected void lastUpdated(){
        this.lastUpdated = OffsetDateTime.now();
    }


    // Relation to user
    @ManyToOne
    @JoinColumn(name = "UserId")
    private UserModel user;
    
    // Relation To Dashboard(Assets)
    @ManyToOne
    @JoinColumn(name = "assetId")
    private DashboardModel dashboard;

}
