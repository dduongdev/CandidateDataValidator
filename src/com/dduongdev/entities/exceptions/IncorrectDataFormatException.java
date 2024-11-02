package com.dduongdev.entities.exceptions;

import java.io.Serial;

public class IncorrectDataFormatException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;

    public IncorrectDataFormatException() {
        super();
    }

    public IncorrectDataFormatException(String message) {
        super(message);
    }
}
