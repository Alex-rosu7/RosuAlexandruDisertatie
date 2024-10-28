package com.rosualexandru.disertatie.Services;

import com.rosualexandru.disertatie.Model.Teacher;
import com.rosualexandru.disertatie.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher createTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }
}
