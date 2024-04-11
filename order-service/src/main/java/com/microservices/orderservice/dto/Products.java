package com.microservices.orderservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Products {
    private String product;
    private int quantity;
}
