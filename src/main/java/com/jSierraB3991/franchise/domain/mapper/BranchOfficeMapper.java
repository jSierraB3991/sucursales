package com.jSierraB3991.franchise.domain.mapper;

import com.jSierraB3991.franchise.domain.model.BranchOffice;
import com.jSierraB3991.franchise.infrastructure.response.BranchOfficeResponse;

import java.util.List;
import java.util.stream.Collectors;

public class BranchOfficeMapper {

    public static BranchOfficeResponse GetResponse(BranchOffice model) {
        return BranchOfficeResponse.builder()
                .id(model.getId())
                .name(model.getName())
                .franchiseResponse(FranchiseMapper.GetResponse(model.getFranchise()))
                .build();
    }

    public static List<BranchOfficeResponse> GetResponse(List<BranchOffice> model) {
        return model.stream().map(BranchOfficeMapper::GetResponse).collect(Collectors.toList());
    }
}
