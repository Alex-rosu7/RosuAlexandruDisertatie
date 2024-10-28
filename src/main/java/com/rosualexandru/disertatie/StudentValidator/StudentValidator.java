package com.rosualexandru.disertatie.StudentValidator;

import com.rosualexandru.disertatie.Exceptions.ValidationException;
import com.rosualexandru.disertatie.Model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentValidator implements Validator<Student> {


    @Override
    public void validate(Student student) throws ValidationException {
        if (student == null) {
            throw new ValidationException("Student data is required");
        }
        if (student.getFirstName() == null || student.getFirstName().isEmpty()) {
            throw new ValidationException("Student first name is required");
        }
        if (student.getSecondName() == null || student.getSecondName().isEmpty()) {
            throw new ValidationException("Student second name is required");
        }
        if (student.getAge() <= 0) {
            throw new ValidationException("Student age must be greater than zero");
        }
    }
}
