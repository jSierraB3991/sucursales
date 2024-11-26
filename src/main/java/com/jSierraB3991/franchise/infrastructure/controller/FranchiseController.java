package com.jSierraB3991.franchise.infrastructure.controller;

import com.jSierraB3991.franchise.domain.service.FranchiseService;
import com.jSierraB3991.franchise.infrastructure.request.FranchiseRequest;
import com.jSierraB3991.franchise.infrastructure.response.FranchiseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/franchise")
@RequiredArgsConstructor
public class FranchiseController {

    private final FranchiseService service;

    @PostMapping
    public FranchiseResponse saveFranchise(@RequestBody FranchiseRequest request) {
        return service.Save(request);
    }

    @GetMapping
    public List<FranchiseResponse> getAll() {
        return service.findAll();
    }


}
