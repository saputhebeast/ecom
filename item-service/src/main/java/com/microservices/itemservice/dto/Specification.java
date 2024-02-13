package com.microservices.itemservice.dto;

import com.microservices.itemservice.dto.types.Color;
import com.microservices.itemservice.dto.types.Material;
import com.microservices.itemservice.dto.types.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Specification {
    private Material material;
    private Color color;
    private Size size;
}
