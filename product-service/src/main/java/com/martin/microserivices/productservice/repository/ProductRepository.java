package com.martin.microserivices.productservice.repository;

import com.martin.microserivices.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

// Paso 3
public interface ProductRepository extends MongoRepository<Product, String> {
}
