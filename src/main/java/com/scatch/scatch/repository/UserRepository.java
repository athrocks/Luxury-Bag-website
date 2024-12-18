package com.scatch.scatch.repository;

import com.scatch.scatch.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String> {
    UserModel findByEmail(String email);
}
