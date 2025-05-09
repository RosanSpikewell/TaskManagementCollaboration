package com.rosan.Task.Management.and.Collaboration.exceptions;

public class EmailAlreadyExist extends RuntimeException{
    public EmailAlreadyExist() {
        super();
    }

    public EmailAlreadyExist(String message) {
        super(message);
    }
}
