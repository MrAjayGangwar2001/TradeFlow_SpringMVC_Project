package com.Portfolio.app.Portfolio;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Portfolio.app.Order.OrderDto;
import com.Portfolio.app.Response.PortfolioResponse;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/portfolio")
public class PortfolioController {

    private final PortfolioService portService;

    @PostMapping("/data/{Id}")
    public PortfolioDto PortfolioUpdate(@RequestBody OrderDto orderDto, @PathVariable Long Id) throws Exception {

        return portService.PortfolioUpdate(Id, orderDto);
    }

    @GetMapping("/all/{userId}")
    public List<PortfolioResponse> getPortfolioByUser(@PathVariable Long userId) throws Exception {
        return portService.getPortfolioByUser(userId);
    }

}
