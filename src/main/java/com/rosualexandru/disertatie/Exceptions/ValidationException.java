package com.rosualexandru.disertatie.Exceptions;

import java.io.Serial;

public class ValidationException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 5L;

    public ValidationException(String msj) {
        super(msj);
    }
}
