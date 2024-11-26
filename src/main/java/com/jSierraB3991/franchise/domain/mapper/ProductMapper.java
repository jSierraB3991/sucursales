package com.jSierraB3991.franchise.domain.mapper;

import com.jSierraB3991.franchise.domain.model.BranchOffice;
import com.jSierraB3991.franchise.domain.model.Product;
import com.jSierraB3991.franchise.infrastructure.response.BranchOfficeByFranchiseResponse;
import com.jSierraB3991.franchise.infrastructure.response.ProductResponse;
import com.jSierraB3991.franchise.infrastructure.response.ProductResponseBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

    public static List<BranchOfficeByFranchiseResponse> GetDataFranchise(Map<BranchOffice, Product> data ) {
        var response =new ArrayList<BranchOfficeByFranchiseResponse>();
        for(var element : data.keySet()) {
            response.add(BranchOfficeByFranchiseResponse.builder()
                            .product(ProductResponseBasic.builder()
                                    .id(data.get(element).getId())
                                    .name(data.get(element).getName())
                                    .stock(data.get(element).getStock())
                                    .build())
                            .name(element.getName())
                            .id(element.getId())
                    .build());
        }
        return response;
    }

}
