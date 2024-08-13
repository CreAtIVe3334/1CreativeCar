package com.example.CreativeCar.exception;

public class SimpleException extends RuntimeException {
    String message;
    public SimpleException(String message) {
        super(message);
        this.message = message;
    }
}
