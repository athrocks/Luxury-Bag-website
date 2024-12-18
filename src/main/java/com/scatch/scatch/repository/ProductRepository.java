package com.scatch.scatch.repository;

import com.scatch.scatch.model.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<ProductModel, String> {

    //    Custom query to find products by name
    //    List<Product> findByName(String name);

}
