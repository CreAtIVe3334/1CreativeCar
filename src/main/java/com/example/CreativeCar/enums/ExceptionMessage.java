package com.example.CreativeCar.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionMessage {

    NOT_FOUND("Not found with id: %s"),
    INVALID_REQUEST("Invalid request data"),
    UNAUTHORIZED("Unauthorized access");

    private final String message;
}
