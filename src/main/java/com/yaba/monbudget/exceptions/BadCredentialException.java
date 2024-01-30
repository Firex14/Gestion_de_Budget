package com.yaba.monbudget.exceptions;

public class BadCredentialException extends GlobalExceptionHandler{
    public BadCredentialException() {
    }

    public BadCredentialException(String message) {
        super(message);
    }
}
