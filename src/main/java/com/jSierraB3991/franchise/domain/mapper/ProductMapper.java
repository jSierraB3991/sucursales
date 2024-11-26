package com.jSierraB3991.franchise.domain.mapper;

import com.jSierraB3991.franchise.domain.model.Franchise;
import com.jSierraB3991.franchise.domain.model.Product;
import com.jSierraB3991.franchise.infrastructure.response.FranchiseResponse;
import com.jSierraB3991.franchise.infrastructure.response.ProductResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductResponse GetResponse(Product model) {
        return ProductResponse.builder()
                .id(model.getId())
                .name(model.getName())
                .stock(model.getStock())
                .branchOffice(BranchOfficeMapper.GetResponse(model.getBranchOffice()))
                .build();
    }

    public static List<ProductResponse> GetResponse(List<Product> model) {
        return model.stream().map(ProductMapper::GetResponse).collect(Collectors.toList());
    }
}
