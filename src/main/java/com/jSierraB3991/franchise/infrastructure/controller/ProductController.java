package com.jSierraB3991.franchise.infrastructure.controller;

import com.jSierraB3991.franchise.domain.service.ProductService;
import com.jSierraB3991.franchise.infrastructure.request.ProductRequest;
import com.jSierraB3991.franchise.infrastructure.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;


    @PostMapping
    public ProductResponse saveFranchise(@RequestBody ProductRequest request) {
        return service.save(request);
    }

    @GetMapping
    public List<ProductResponse> getAll() {
        return service.findAll();
    }

    @DeleteMapping("/{product-id}")
    public void deleteProduct(@PathVariable("product-id") String productId) {
        service.delete(productId);
    }
}
