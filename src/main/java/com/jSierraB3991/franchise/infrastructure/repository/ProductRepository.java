package com.jSierraB3991.franchise.infrastructure.repository;

import com.jSierraB3991.franchise.domain.model.BranchOffice;
import com.jSierraB3991.franchise.domain.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.io.Serializable;
import java.util.List;

public interface ProductRepository extends MongoRepository<Product, Serializable> {
    @Query("{ 'branch-office' : { $in: ?0 } }")
    List<Product> findProductsByBranchOfficeId(List<String> listBranchOffice);

    @Query("{ 'branchOffice' : { $in: ?0 } }")
    List<Product> findProductsByBranchOffice(List<BranchOffice> listBranchOffice);

    List<Product> findProductsByBranchOfficeId(String listBranchOffice);
}
