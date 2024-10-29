package com.rosualexandru.disertatie.Controllers;

import com.rosualexandru.disertatie.Model.Teacher;
import com.rosualexandru.disertatie.Services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public void getTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping()
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        return teacherService.getAllTeachers()
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }


    @GetMapping("/{teacherEmail}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable String teacherEmail) {
        return teacherService.getTeacherByEmail(teacherEmail)
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping()
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        Teacher createdTeacher = teacherService.createTeacher(teacher);
        return new ResponseEntity<>(createdTeacher, HttpStatus.CREATED);
    }

    @PutMapping("/{teacherEmail}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable String teacherEmail, @RequestBody Teacher teacher) {
        return teacherService.updateTeacher(teacherEmail, teacher)
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/email/{email}")
    public ResponseEntity<Void> deleteTeacherByEmail(@PathVariable String email) {
        boolean isDeleted = teacherService.deleteByEmail(email);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
