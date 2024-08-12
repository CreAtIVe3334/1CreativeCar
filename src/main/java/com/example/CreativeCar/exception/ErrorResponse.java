package com.example.CreativeCar.exception;

import lombok.Builder;

@Builder
public record ErrorResponse(String message) {

}
