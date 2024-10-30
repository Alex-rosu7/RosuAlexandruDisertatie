package com.rosualexandru.disertatie.Controllers;

import com.rosualexandru.disertatie.Model.Student;
import com.rosualexandru.disertatie.Model.Teacher;
import com.rosualexandru.disertatie.Services.StudentService;
import com.rosualexandru.disertatie.StudentValidator.StudentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping()
    public ResponseEntity<List<Student>> getAllStudents() {
        return studentService.getAllStudents()
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }


    @GetMapping("/{email}")
    public ResponseEntity<Student> getStudent(@PathVariable String email) {
        return studentService.getStudentByEmail(email)
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping()
    public ResponseEntity<String> createStudent(@RequestBody Student student) {

        try {

            studentValidator.validate(student);
            Student createdStudent = studentService.createStudent(student);
            return new ResponseEntity<>(createdStudent.toString(), HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create student: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/email/{email}")
    public ResponseEntity<Student> updateStudent(@PathVariable String email, @RequestBody Student updatedStudent) {
        return studentService.updateStudent(email, updatedStudent)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/email/{email}")
    public ResponseEntity<Void> deleteTeacherByEmail(@PathVariable String email) {
        boolean isDeleted = studentService.deleteByEmail(email);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
