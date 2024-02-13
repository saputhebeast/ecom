package com.microservices.itemservice.service.impl;

import com.microservices.itemservice.domain.Item;
import com.microservices.itemservice.dto.ItemFilterDto;
import com.microservices.itemservice.dto.ItemRequestDto;
import com.microservices.itemservice.dto.ItemResponseDto;
import com.microservices.itemservice.feign.IdentityServiceClient;
import com.microservices.itemservice.service.BL.ItemServiceBL;
import com.microservices.itemservice.service.ItemService;
import com.microservices.itemservice.service.validation.ItemValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemServiceBL itemServiceBL;

    @Autowired
    ItemValidation itemValidation;

    @Autowired
    IdentityServiceClient identityServiceClient;

    @Override
    public ResponseEntity createItem(ItemRequestDto itemRequestDto) {
        ResponseEntity<String> response = identityServiceClient.checkHealth();
        System.out.println(response.getBody());
        ItemResponseDto itemResponseDto = itemServiceBL.createNewItem(itemRequestDto);
        if (itemResponseDto != null) {
            return new ResponseEntity<>(itemResponseDto, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity getAllItems(ItemFilterDto itemFilterDto) {
        Page<Item> itemResponseDtos = itemServiceBL.getAllItems(itemFilterDto);
        if (itemResponseDtos != null) {
            return new ResponseEntity<>(itemResponseDtos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity getItem(String id) {
        ItemResponseDto itemResponseDto = itemServiceBL.getItemById(id);
        if (itemResponseDto != null) {
            return new ResponseEntity<>(itemResponseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity updateItem(String id, ItemRequestDto itemRequestDto) {
        ItemResponseDto itemResponseDto = itemServiceBL.updateItem(id, itemRequestDto);
        if (itemResponseDto != null) {
            return new ResponseEntity<>(itemResponseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
