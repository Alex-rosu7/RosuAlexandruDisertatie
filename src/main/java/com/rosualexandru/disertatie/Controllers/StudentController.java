package com.rosualexandru.disertatie.Controllers;

import com.rosualexandru.disertatie.Model.Student;
import com.rosualexandru.disertatie.Services.StudentService;
import com.rosualexandru.disertatie.StudentValidator.StudentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    private StudentValidator studentValidator;

    @Autowired
    public void StudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void StudentValidator(StudentValidator studentValidator) {
        this.studentValidator = studentValidator;
    }

    @GetMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("Student API is running");
    }

    @PostMapping("")
    public ResponseEntity<String> createStudent(@RequestBody Student student) {

        studentValidator.validate(student);

        try {
            Student createdStudent = studentService.createStudent(student);
            return new ResponseEntity<>(createdStudent.toString(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create student: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
