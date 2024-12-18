package com.scatch.scatch.repository;

import com.scatch.scatch.model.OwnerModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends MongoRepository<OwnerModel, Integer> {

}
