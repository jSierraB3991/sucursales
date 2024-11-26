package com.jSierraB3991.franchise.infrastructure.service.impl;

import com.jSierraB3991.franchise.domain.mapper.ProductMapper;
import com.jSierraB3991.franchise.domain.model.Product;
import com.jSierraB3991.franchise.domain.service.ProductService;
import com.jSierraB3991.franchise.infrastructure.repository.BranchOfficeRepository;
import com.jSierraB3991.franchise.infrastructure.repository.ProductRepository;
import com.jSierraB3991.franchise.infrastructure.request.ProductRequest;
import com.jSierraB3991.franchise.infrastructure.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final BranchOfficeRepository branchOfficeRepository;

    @Override
    public ProductResponse save(ProductRequest request) {

        var data = branchOfficeRepository.findById(request.getBranchOfficeId());
        if (data.isEmpty()) {
            throw new RuntimeException("INVALID BRANCH OFFICE IN PRODUCT");
        }
        var model = Product.builder()
                .id(new ObjectId().toString())
                .name(request.getName())
                .stock(0)
                .branchOffice(data.get())
                .build();
        return ProductMapper.GetResponse(repository.save(model));
    }

    @Override
    public List<ProductResponse> findAll() {
        var data = repository.findAll();
        return ProductMapper.GetResponse(data);
    }

    private Product getProductById(String productId) {
        var data = repository.findById(productId);
        if (data.isEmpty()) {
            throw new RuntimeException("THIS PRODUCT ID IS INVALID");
        }
        return data.get();
    }

    @Override
    public void delete(String productId) {
        var product = getProductById(productId);
        if (product.getStock() != 0) {
            throw new RuntimeException("THIS PRODUCT HAVE STOCK AVAILABLE");
        }
        repository.delete(product);
    }
}
