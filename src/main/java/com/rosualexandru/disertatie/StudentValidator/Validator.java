package com.rosualexandru.disertatie.StudentValidator;

import com.rosualexandru.disertatie.Exceptions.ValidationException;

public interface Validator<E> {

   void validate(E var) throws ValidationException;
}
