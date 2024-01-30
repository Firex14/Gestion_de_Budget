package com.yaba.monbudget.exceptions;

public class NotFoundException extends GlobalExceptionHandler{
    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }
}
