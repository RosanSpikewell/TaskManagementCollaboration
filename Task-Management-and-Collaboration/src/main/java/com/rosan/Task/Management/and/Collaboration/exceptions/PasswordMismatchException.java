package com.rosan.Task.Management.and.Collaboration.exceptions;

public class PasswordMismatchException extends RuntimeException{
    public PasswordMismatchException() {
    }

    public PasswordMismatchException(String message) {
        super(message);
    }
}
