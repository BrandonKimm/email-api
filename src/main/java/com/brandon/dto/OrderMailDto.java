package com.brandon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderMailDto {
    private Long orderId;
    private LocalDateTime orderDate;
    private String memberEmail;
    private String memberName;
    private List<OrderMailProductListDto> orderProducts;
    private int orderTotalPrice;
    private int orderTotalProductQuantity;
}

