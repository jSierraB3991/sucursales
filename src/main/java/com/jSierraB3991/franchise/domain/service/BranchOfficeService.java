package com.jSierraB3991.franchise.domain.service;

import com.jSierraB3991.franchise.infrastructure.request.BranchOfficeRequest;
import com.jSierraB3991.franchise.infrastructure.response.BranchOfficeResponse;

import java.util.List;

public interface BranchOfficeService {
    List<BranchOfficeResponse> findAll();
    BranchOfficeResponse Save(BranchOfficeRequest request);
    BranchOfficeResponse FindById(String id);


}
