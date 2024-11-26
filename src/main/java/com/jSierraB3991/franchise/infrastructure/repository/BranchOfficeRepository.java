package com.jSierraB3991.franchise.infrastructure.repository;

import com.jSierraB3991.franchise.domain.model.BranchOffice;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;

public interface BranchOfficeRepository extends MongoRepository<BranchOffice, Serializable> {
}
