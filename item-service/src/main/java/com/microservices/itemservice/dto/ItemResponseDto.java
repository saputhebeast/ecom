package com.microservices.itemservice.dto;

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
    private Specification specification;
    private double price;
    private List<FrequentQuestion> faqs;
    private List<String> additionalFeatures;
    private Long quantity;
}
