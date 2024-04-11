package com.microservices.orderservice.service;

import com.microservices.orderservice.dto.OrderRequest;
import org.springframework.http.ResponseEntity;

public interface OrderService {

    ResponseEntity createOrder(OrderRequest orderRequest);
}
