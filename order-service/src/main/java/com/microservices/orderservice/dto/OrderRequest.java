package com.microservices.orderservice.dto;

import com.microservices.orderservice.type.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private String user;
    private List<Products> products;
    private double totalPrice;
    private Status status;
}
