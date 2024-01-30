package com.yaba.monbudget.exceptions;

public class AlreadyExistException extends GlobalExceptionHandler{
    public AlreadyExistException() {
    }

    public AlreadyExistException(String message) {
        super(message);
    }
}
