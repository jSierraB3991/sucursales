package com.jSierraB3991.franchise.infrastructure.repository;

import com.jSierraB3991.franchise.domain.model.Franchise;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface FranchiseRepository extends MongoRepository<Franchise, Serializable> {
}
