package com.rosualexandru.disertatie.Services;

import com.rosualexandru.disertatie.Model.Student;
import com.rosualexandru.disertatie.Model.Teacher;
import com.rosualexandru.disertatie.Repositories.TeacherRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Optional<List<Teacher>> getAllTeachers() {
        return Optional.of(teacherRepository.findAll());
    }

    public Optional<Teacher> getTeacherByEmail(String teacherEmail) {
        return teacherRepository.findByEmail(teacherEmail);
    }

    public Optional<Teacher> updateTeacher(String email, Teacher updatedTeacher) {
        return getOptionalEntity(updatedTeacher, teacherRepository.findByEmail(email));
    }

    @NotNull
    private Optional<Teacher> getOptionalEntity(Teacher updatedTeacher, Optional<Teacher> entity) {
        return entity.map(teacher -> {
            teacher.setFirstName((updatedTeacher.getFirstName()));
            teacher.setSecondName(updatedTeacher.getSecondName());
            teacher.setEmail(updatedTeacher.getEmail());
            teacher.setAge(updatedTeacher.getAge());
            return teacherRepository.save(teacher);
        });
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public boolean deleteByEmail(String email) {
        Optional<Teacher> teacher = teacherRepository.findByEmail(email);
        if (teacher.isPresent()) {
            teacherRepository.delete(teacher.get());
            return true;
        }
        return false;
    }
}
