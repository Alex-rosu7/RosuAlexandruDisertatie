package com.rosualexandru.disertatie.Repositories;

import com.rosualexandru.disertatie.Model.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends MongoRepository<Teacher, String> {
    Teacher findByEmail(String email);
}
