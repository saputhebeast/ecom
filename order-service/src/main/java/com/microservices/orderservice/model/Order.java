package com.microservices.orderservice.model;

import com.microservices.orderservice.dto.Products;
import com.microservices.orderservice.type.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Getter
@Setter
@Builder
public class Order {

    @Id
    private String id;
    private String user;
    private List<Products> products;
    private double totalPrice;
    private Status status;

}
