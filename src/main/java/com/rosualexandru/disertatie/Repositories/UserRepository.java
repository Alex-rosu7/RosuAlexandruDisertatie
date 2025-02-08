package com.rosualexandru.disertatie.Repositories;

import com.rosualexandru.disertatie.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}