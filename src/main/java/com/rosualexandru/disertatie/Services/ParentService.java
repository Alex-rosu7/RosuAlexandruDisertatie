package com.rosualexandru.disertatie.Services;

import com.rosualexandru.disertatie.Model.Parent;
import com.rosualexandru.disertatie.Model.Student;
import com.rosualexandru.disertatie.Repositories.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentService {

    private final ParentRepository parentRepository;

    @Autowired
    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    public Parent createParent(Parent parent) {
        return parentRepository.save(parent);
    }

    public Optional<List<Parent>> getAllParents() {
        return Optional.of(parentRepository.findAll());
    }

    public Optional<Parent> getParentByEmail(String email) {
        return parentRepository.findParentByEmail(email);
    }

    public Optional<Parent> updateParent(String email, Student updatedStudent) {
        return parentRepository.findByEmail(email).map(parent -> {
            parent.setFirstName((updatedStudent.getFirstName()));
            parent.setSecondName(updatedStudent.getSecondName());
            parent.setEmail(updatedStudent.getEmail());
            parent.setAge(updatedStudent.getAge());
            return parentRepository.save(parent);
        });
    }
}
