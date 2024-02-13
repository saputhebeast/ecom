package com.microservices.itemservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemFilterDto {
    private int page = 0;
    private int size = 10;
}
