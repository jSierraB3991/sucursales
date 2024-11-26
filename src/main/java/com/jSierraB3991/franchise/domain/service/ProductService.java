package com.jSierraB3991.franchise.domain.service;

import com.jSierraB3991.franchise.domain.model.Product;
import com.jSierraB3991.franchise.infrastructure.request.ProductRequest;
import com.jSierraB3991.franchise.infrastructure.response.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse save(ProductRequest request);
    List<ProductResponse> findAll();
    void delete(String productId);
    Product getProductById(String productId);
    ProductResponse updateStock(String productId, Integer newStock);
}
