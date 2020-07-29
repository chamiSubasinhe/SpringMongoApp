package com.javatechie.spring.mongo.api.repository;

import com.javatechie.spring.mongo.api.model.Sales;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SalesRepository extends MongoRepository<Sales, String> {
}
