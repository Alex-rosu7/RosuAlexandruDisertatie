package com.rosualexandru.disertatie.Services;

import com.rosualexandru.disertatie.Model.Teacher;
import com.rosualexandru.disertatie.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        Teacher teacher = teacherRepository.findByEmail(teacherEmail);
        return Optional.of(teacher);
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}
