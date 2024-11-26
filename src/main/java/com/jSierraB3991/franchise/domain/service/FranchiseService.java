package com.jSierraB3991.franchise.domain.service;

import com.jSierraB3991.franchise.infrastructure.request.FranchiseRequest;
import com.jSierraB3991.franchise.infrastructure.response.FranchiseResponse;

import java.util.List;


public interface FranchiseService {
    List<FranchiseResponse> findAll();
    FranchiseResponse Save(FranchiseRequest request);
    FranchiseResponse FindById(String id);
}
