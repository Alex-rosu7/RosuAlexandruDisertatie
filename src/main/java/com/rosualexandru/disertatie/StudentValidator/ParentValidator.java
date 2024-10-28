package com.rosualexandru.disertatie.StudentValidator;

import com.rosualexandru.disertatie.Exceptions.ValidationException;
import com.rosualexandru.disertatie.Model.Parent;
import org.springframework.stereotype.Component;

@Component
public class ParentValidator implements Validator<Parent> {
    @Override
    public void validate(Parent parent) throws ValidationException {
        if (parent == null) {
            throw new ValidationException("Parent data is required");
        }
        if (parent.getFirstName() == null || parent.getFirstName().isEmpty()) {
            throw new ValidationException("Parent first name is required");
        }
        if (parent.getSecondName() == null || parent.getSecondName().isEmpty()) {
            throw new ValidationException("Parent second name is required");
        }
        if (parent.getAge() <= 18) {
            throw new ValidationException("Parent age must be greater than eighteen");
        }

    }
}
