package com.rosualexandru.disertatie.Repositories;

import com.rosualexandru.disertatie.Model.Parent;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParentRepository extends MongoRepository<Parent, String> {

    Optional<Parent> findParentByEmail(String email);

    Optional<Parent> findByEmail(String email);

}
