package com.jSierraB3991.franchise.infrastructure.service.impl;

import com.jSierraB3991.franchise.domain.mapper.FranchiseMapper;
import com.jSierraB3991.franchise.domain.model.Franchise;
import com.jSierraB3991.franchise.domain.service.FranchiseService;
import com.jSierraB3991.franchise.infrastructure.repository.FranchiseRepository;
import com.jSierraB3991.franchise.infrastructure.request.FranchiseRequest;
import com.jSierraB3991.franchise.infrastructure.response.FranchiseResponse;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FranchiseServiceImpl implements FranchiseService {

    private final FranchiseRepository repository;

    @Override
    public List<FranchiseResponse> findAll() {
        var data = repository.findAll();
        return FranchiseMapper.GetResponse(data);
    }

    @Override
    public FranchiseResponse Save(FranchiseRequest request) {
        var model = Franchise.builder()
                .id(new ObjectId().toString())
                .name(request.getName())
                .build();
        return FranchiseMapper.GetResponse(repository.save(model));
    }

    @Override
    public FranchiseResponse FindById(String id) {
        var data = repository.findById(id);
        if (data.isEmpty()) {
            throw new RuntimeException("INVALID ID OF FRANCHISE");
        }
        return FranchiseMapper.GetResponse(data.get());
    }
}
