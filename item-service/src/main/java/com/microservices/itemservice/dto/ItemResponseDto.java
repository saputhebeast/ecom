package com.microservices.itemservice.dto;

import com.microservices.itemservice.dto.types.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class ItemResponseDto {
    private String id;
    private String title;
    private List<String> images;
    private String description;
    private Category category;
    private double price;
    private Long quantity;
}
