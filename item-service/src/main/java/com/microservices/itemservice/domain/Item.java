package com.microservices.itemservice.domain;

import com.microservices.itemservice.dto.FrequentQuestion;
import com.microservices.itemservice.dto.Specification;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.List;

@Document(collection = "item")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {

    @Id
    @Field(targetType = FieldType.OBJECT_ID)
    private String id;
    private String title;
    private List<String> images;
    private String description;
    private Specification specifications;
    private double price;
    private List<FrequentQuestion> faqs;
    private List<String> additionalFeatures;
    private Long quantity;

}
