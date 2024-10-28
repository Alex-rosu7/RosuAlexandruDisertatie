package com.rosualexandru.disertatie.Repositories;

import com.rosualexandru.disertatie.Model.Parent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends MongoRepository<Parent, String> {
}
