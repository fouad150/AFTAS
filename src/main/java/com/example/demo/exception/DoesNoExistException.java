package com.example.demo.exception;

public class DoesNoExistException extends RuntimeException {

    public DoesNoExistException(String message) {
        super(message);
    }

}
