package com.rosualexandru.disertatie.Services;

import com.rosualexandru.disertatie.Model.Student;
import com.rosualexandru.disertatie.Model.Teacher;
import com.rosualexandru.disertatie.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Optional<List<Student>> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return Optional.of(students);
    }

    public Optional<Student> updateStudent(String email, Student updatedStudent) {
        return studentRepository.findByEmail(email).map(student -> {
            student.setFirstName((updatedStudent.getFirstName()));
            student.setSecondName(updatedStudent.getSecondName());
            student.setEmail(updatedStudent.getEmail());
            student.setAge(updatedStudent.getAge());
            return studentRepository.save(student);
        });
    }

    public Optional<Student> getStudentByEmail(String studentEmail) {
        Student student = studentRepository.getStudentByEmail(studentEmail);
        return Optional.of(student);
    }

    public boolean deleteByEmail(String email) {
        Optional<Student> student = studentRepository.findByEmail(email);
        if (student.isPresent()) {
            studentRepository.delete(student.get());
            return true;
        }
        return false;
    }
}
