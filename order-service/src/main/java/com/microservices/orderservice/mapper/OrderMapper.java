package com.microservices.orderservice.mapper;

import com.microservices.orderservice.dto.OrderRequest;
import com.microservices.orderservice.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order orderRequestToOrder(OrderRequest orderRequest) {
        return Order.builder()
                .user(orderRequest.getUser())
                .status(orderRequest.getStatus())
                .products(orderRequest.getProducts())
                .totalPrice(orderRequest.getTotalPrice())
                .status(orderRequest.getStatus())
                .build();
    }
}
