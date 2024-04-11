package com.microservices.itemservice.repository;

import com.microservices.itemservice.domain.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemDao extends MongoRepository<Item, String> {
}
