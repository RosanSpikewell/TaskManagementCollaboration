package com.rosan.Task.Management.and.Collaboration.exceptions;

public class ErrorWhileCreatingEntity extends  RuntimeException{
    public ErrorWhileCreatingEntity() {
    }

    public ErrorWhileCreatingEntity(String message) {
        super(message);
    }
}
