package com.yaba.monbudget.exceptions;

public class GlobalExceptionHandler extends RuntimeException{

    public GlobalExceptionHandler() {
    }

    public GlobalExceptionHandler(String message) {
        super(message);
    }
}
