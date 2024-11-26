package com.jSierraB3991.franchise.infrastructure.repository;

import com.jSierraB3991.franchise.domain.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;

public interface ProductRepository extends MongoRepository<Product, Serializable> {
}
