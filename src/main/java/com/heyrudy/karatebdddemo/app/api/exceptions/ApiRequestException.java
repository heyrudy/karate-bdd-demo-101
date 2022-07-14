package com.heyrudy.karatebdddemo.app.api.exceptions;

public final class ApiRequestException extends RuntimeException {

    public ApiRequestException(String message) {
        super(message);
    }
}
