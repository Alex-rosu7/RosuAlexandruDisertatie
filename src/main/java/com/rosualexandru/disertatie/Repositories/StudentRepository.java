package com.rosualexandru.disertatie.Repositories;


import com.rosualexandru.disertatie.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    Student getStudentByEmail(String email);
    Optional<Student> findByEmail(String email);
}
