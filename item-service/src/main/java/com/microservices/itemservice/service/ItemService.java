package com.microservices.itemservice.service;

import com.microservices.itemservice.dto.ItemFilterDto;
import com.microservices.itemservice.dto.ItemRequestDto;
import org.springframework.http.ResponseEntity;

public interface ItemService {

    ResponseEntity createItem(ItemRequestDto itemRequestDto);

    ResponseEntity getAllItems(ItemFilterDto itemFilterDto);

    ResponseEntity getItem(String id);

    ResponseEntity updateItem(String id, ItemRequestDto itemRequestDto);
}
