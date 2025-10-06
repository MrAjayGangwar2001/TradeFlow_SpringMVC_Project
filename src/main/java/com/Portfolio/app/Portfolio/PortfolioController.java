package com.Portfolio.app.Portfolio;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Portfolio.app.Order.OrderDto;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/portfolio")
public class PortfolioController {

    private final PortfolioService portService;

    @PostMapping("/data/{Id}")
    public PortfolioDto PortfolioUpdate(@RequestBody OrderDto orderDto, @PathVariable Long Id ) throws Exception {
       
        
        return portService.PortfolioUpdate(Id, orderDto);
    }
    
}
