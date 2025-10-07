package com.Portfolio.app.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PortfolioResponse {

    private Long portfolioId;
    private Long userId;
    private Long assetId;
    private String assetName;
    private Double assetQuantity;
    private Double averagePrice;
    private Double totalValue;
}
