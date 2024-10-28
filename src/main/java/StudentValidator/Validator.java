package StudentValidator;

import Exceptions.ValidationException;

import java.util.List;

public interface Validator<E> {

   void validate(E var) throws ValidationException;
}
