package com.jSierraB3991.franchise.infrastructure.controller;

import com.jSierraB3991.franchise.domain.service.BranchOfficeService;
import com.jSierraB3991.franchise.infrastructure.request.BranchOfficeRequest;
import com.jSierraB3991.franchise.infrastructure.response.BranchOfficeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/branch-office")
@RequiredArgsConstructor
public class BranchOfficeController {

    private final BranchOfficeService service;

    @PostMapping
    public BranchOfficeResponse saveBranchOffice(@RequestBody BranchOfficeRequest request) {
        return service.Save(request);
    }

    @GetMapping
    public List<BranchOfficeResponse> getAll() {
        return service.findAll();
    }

}
