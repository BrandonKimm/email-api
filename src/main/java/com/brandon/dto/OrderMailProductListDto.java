package com.brandon.dto;

import lombok.Data;

@Data
public class OrderMailProductListDto {
    private Long orderProductId;
    private String name;
    private int price;
    private int orderProductPrice;
    private int orderProductQuantity;
}
