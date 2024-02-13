package com.microservices.itemservice.transformer;

import com.microservices.itemservice.domain.Item;
import com.microservices.itemservice.dto.FrequentQuestion;
import com.microservices.itemservice.dto.ItemRequestDto;
import com.microservices.itemservice.dto.ItemResponseDto;
import com.microservices.itemservice.dto.Specification;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ItemTransformer {

    public Item reverseTransformer(ItemRequestDto itemRequestDto) {
        return Item.builder()
                .title(itemRequestDto.getTitle())
                .images(itemRequestDto.getImages())
                .description(itemRequestDto.getDescription())
                .price(itemRequestDto.getPrice())
                .specifications(Specification.builder()
                        .material(itemRequestDto.getSpecification().getMaterial())
                        .color(itemRequestDto.getSpecification().getColor())
                        .size(itemRequestDto.getSpecification().getSize())
                        .build())
                .faqs(itemRequestDto.getFaqs().stream()
                        .map(question -> FrequentQuestion.builder()
                                .question(question.getQuestion())
                                .answer(question.getAnswer())
                                .build())
                        .collect(Collectors.toList()))
                .additionalFeatures(itemRequestDto.getAdditionalFeatures())
                .quantity(itemRequestDto.getQuantity())
                .build();
    }

    public ItemResponseDto transform(Item savedItem) {
        return ItemResponseDto.builder()
                .id(savedItem.getId())
                .title(savedItem.getTitle())
                .images(savedItem.getImages())
                .description(savedItem.getDescription())
                .price(savedItem.getPrice())
                .specification(Specification.builder()
                        .material(savedItem.getSpecifications().getMaterial())
                        .color(savedItem.getSpecifications().getColor())
                        .size(savedItem.getSpecifications().getSize())
                        .build())
                .faqs(savedItem.getFaqs().stream()
                        .map(question -> FrequentQuestion.builder()
                                .question(question.getQuestion())
                                .answer(question.getAnswer())
                                .build())
                        .collect(Collectors.toList()))
                .additionalFeatures(savedItem.getAdditionalFeatures())
                .quantity(savedItem.getQuantity())
                .build();
    }

    public Item updateItemFromDto(ItemRequestDto itemRequestDto, Item existingItem) {
        if (itemRequestDto.getTitle() != null && !itemRequestDto.getTitle().isEmpty()) {
            existingItem.setTitle(itemRequestDto.getTitle());
        }

        if (itemRequestDto.getImages() != null) {
            existingItem.setImages(itemRequestDto.getImages());
        }

        if (itemRequestDto.getDescription() != null) {
            existingItem.setDescription(itemRequestDto.getDescription());
        }

        if (itemRequestDto.getPrice() > 0) {
            existingItem.setPrice(itemRequestDto.getPrice());
        }

        if (itemRequestDto.getSpecification() != null) {
            Specification specification = Specification.builder()
                    .material(itemRequestDto.getSpecification().getMaterial())
                    .color(itemRequestDto.getSpecification().getColor())
                    .size(itemRequestDto.getSpecification().getSize())
                    .build();
            existingItem.setSpecifications(specification);
        }

        if (itemRequestDto.getAdditionalFeatures() != null) {
            existingItem.setAdditionalFeatures(itemRequestDto.getAdditionalFeatures());
        }

        if (itemRequestDto.getFaqs() != null) {
            existingItem.setFaqs(itemRequestDto.getFaqs());
        }

        if (itemRequestDto.getQuantity() != null) {
            existingItem.setQuantity(itemRequestDto.getQuantity());
        }

        return existingItem;
    }

}
