package com.jSierraB3991.franchise.infrastructure.service.impl;

import com.jSierraB3991.franchise.domain.mapper.BranchOfficeMapper;
import com.jSierraB3991.franchise.domain.model.BranchOffice;
import com.jSierraB3991.franchise.domain.service.BranchOfficeService;
import com.jSierraB3991.franchise.infrastructure.repository.BranchOfficeRepository;
import com.jSierraB3991.franchise.infrastructure.repository.FranchiseRepository;
import com.jSierraB3991.franchise.infrastructure.request.BranchOfficeRequest;
import com.jSierraB3991.franchise.infrastructure.response.BranchOfficeResponse;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchOfficeServiceImpl implements BranchOfficeService {
    private final BranchOfficeRepository repository;
    private final FranchiseRepository franchiseRepository;

    @Override
    public List<BranchOfficeResponse> findAll() {
        var data = repository.findAll();
        return BranchOfficeMapper.GetResponse(data);
    }

    @Override
    public BranchOfficeResponse Save(BranchOfficeRequest request) {
        var data = franchiseRepository.findById(request.getFranchiseId());
        if (data.isEmpty()) {
            throw new RuntimeException("INVALID FRANCHISE IN BRANCH OFFICE");
        }


        var model = BranchOffice.builder()
                .id(new ObjectId().toString())
                .franchise(data.get())
                .name(request.getName())
                .build();
        return BranchOfficeMapper.GetResponse(repository.save(model));
    }

    @Override
    public BranchOfficeResponse FindById(String id) {
        var data = repository.findById(id);
        if (data.isEmpty()) {
            throw new RuntimeException("INVALID ID OF FRANCHISE");
        }
        return BranchOfficeMapper.GetResponse(data.get());
    }

}
