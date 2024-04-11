package com.microservices.orderservice.service.impl;

import com.microservices.orderservice.dto.OrderEvent;
import com.microservices.orderservice.dto.OrderRequest;
import com.microservices.orderservice.mapper.OrderMapper;
import com.microservices.orderservice.model.Order;
import com.microservices.orderservice.producer.OrderProducer;
import com.microservices.orderservice.repository.OrderRepository;
import com.microservices.orderservice.service.OrderService;
import com.microservices.orderservice.type.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderProducer orderProducer;

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    @Override
    public ResponseEntity createOrder(OrderRequest orderRequest) {
        Order order = orderMapper.orderRequestToOrder(orderRequest);
        Order savedOrder = orderRepository.save(order);

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus(Status.PENDING);
        orderEvent.setMessage("Order is in pending status!");
        orderEvent.setOrderRequest(orderRequest);

        orderProducer.sendMessage(orderEvent);

        return new ResponseEntity<>(savedOrder, HttpStatusCode.valueOf(200));
    }
}
