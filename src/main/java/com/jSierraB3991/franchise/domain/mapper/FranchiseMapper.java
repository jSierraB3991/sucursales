package com.jSierraB3991.franchise.domain.mapper;


import com.jSierraB3991.franchise.domain.model.Franchise;
import com.jSierraB3991.franchise.infrastructure.response.FranchiseResponse;

import java.util.List;
import java.util.stream.Collectors;

public class FranchiseMapper {

    public static FranchiseResponse GetResponse(Franchise model) {
        return FranchiseResponse.builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }

    public static List<FranchiseResponse> GetResponse(List<Franchise> model) {
        return model.stream().map(FranchiseMapper::GetResponse).collect(Collectors.toList());
    }

}
