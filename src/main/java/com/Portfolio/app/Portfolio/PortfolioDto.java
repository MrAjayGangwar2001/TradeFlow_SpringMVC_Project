package com.Portfolio.app.Portfolio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PortfolioDto {

    private Long portfolioId;
    private Double totalQuantity;
    private Double avgBuyPrice;
}
