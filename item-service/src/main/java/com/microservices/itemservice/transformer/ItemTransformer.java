package com.microservices.itemservice.transformer;

import com.microservices.itemservice.domain.Item;
import com.microservices.itemservice.dto.ItemRequestDto;
import com.microservices.itemservice.dto.ItemResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ItemTransformer {

    public Item reverseTransformer(ItemRequestDto itemRequestDto) {
        return Item.builder()
                .title(itemRequestDto.getTitle())
                .images(itemRequestDto.getImages())
                .description(itemRequestDto.getDescription())
                .price(itemRequestDto.getPrice())
                .category(itemRequestDto.getCategory())
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
                .category(savedItem.getCategory())
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

        if (itemRequestDto.getCategory() != null) {
            existingItem.setCategory(itemRequestDto.getCategory());
        }

        if (itemRequestDto.getQuantity() != null) {
            existingItem.setQuantity(itemRequestDto.getQuantity());
        }

        return existingItem;
    }

}
