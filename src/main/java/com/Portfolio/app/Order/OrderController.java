package com.Portfolio.app.Order;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService os;


    @PostMapping("/{Id}/order")
    public CompletableFuture<String> OrderPost(@Valid @PathVariable Long Id, @RequestBody OrderDto orderDto) throws Exception {
        
        return os.OrderPost(Id, orderDto);
    }

    @GetMapping("/orders")
    public List<OrderDto> GetAllOrders() throws Exception {
        return os.GetAllOrders();
    }
    
    
}
