package com.microservices.itemservice.controller;

import com.microservices.itemservice.dto.ItemFilterDto;
import com.microservices.itemservice.dto.ItemRequestDto;
import com.microservices.itemservice.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/item")
@Slf4j
@Validated
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping
    public ResponseEntity createItem(@RequestBody ItemRequestDto itemRequestDto) {
        return itemService.createItem(itemRequestDto);
    }

    @GetMapping
    public ResponseEntity getAllItems(@RequestBody ItemFilterDto itemFilterDto) {
        return itemService.getAllItems(itemFilterDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity getItem(@PathVariable("id") String id) {
        return itemService.getItem(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateItem(@PathVariable("id") String id, @RequestBody ItemRequestDto itemRequestDto) {
        return itemService.updateItem(id, itemRequestDto);
    }
}
