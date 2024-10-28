package com.rosualexandru.disertatie.Repositories;


import com.rosualexandru.disertatie.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
}
