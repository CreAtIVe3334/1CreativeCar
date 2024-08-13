package com.example.CreativeCar.exception;

public class BalanceException extends RuntimeException {
    String message;
    public BalanceException(String message) {
        super(message);
        this.message = message;
    }
}
