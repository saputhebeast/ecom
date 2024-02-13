package com.microservices.itemservice.service.BL;

import com.microservices.itemservice.domain.Item;
import com.microservices.itemservice.dto.ItemFilterDto;
import com.microservices.itemservice.dto.ItemRequestDto;
import com.microservices.itemservice.dto.ItemResponseDto;
import com.microservices.itemservice.repository.ItemDao;
import com.microservices.itemservice.transformer.ItemTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ItemServiceBL {

    @Autowired
    ItemDao itemDao;

    @Autowired
    ItemTransformer itemTransformer;

    public ItemResponseDto createNewItem(ItemRequestDto itemRequestDto) {
        Item item = itemTransformer.reverseTransformer(itemRequestDto);
        Item savedItem = itemDao.save(item);
        return itemTransformer.transform(savedItem);
    }

    public Page<Item> getAllItems(ItemFilterDto itemFilterDto) {
        PageRequest pageRequest = PageRequest.of(itemFilterDto.getPage(), itemFilterDto.getSize());
        return itemDao.findAll(pageRequest);
    }

    public ItemResponseDto getItemById(String id) {
        Optional<Item> item = itemDao.findById(id);
        return itemTransformer.transform(item.get());
    }

    public ItemResponseDto updateItem(String id, ItemRequestDto itemRequestDto) {
        Optional<Item> optionalItem = itemDao.findById(id);
        if (optionalItem.isPresent()) {
            Item itemToUpdate = optionalItem.get();
            Item updatedItem = itemTransformer.updateItemFromDto(itemRequestDto, itemToUpdate);
            Item savedItem = itemDao.save(updatedItem);
            return itemTransformer.transform(savedItem);
        }
        return null;
    }
}
