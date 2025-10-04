package com.Portfolio.app.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.Portfolio.app.Enum.OrderType;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {


    private Long orderId;
    // {  These assetname and price will use from dashboard Entity which is already defined
    // private Double price;  } 
    
    @NotBlank
    private String assetName;
    private OrderType orderType;
    
    @NotNull
    @Min(value = 1, message = "AssetQuentity can not be less than 1")
    @Max(value = 1000, message = "AssetQuentity can not be More than 1000 per Order")
    @Positive
    private Long assetQuantity;
    private String status;
}
