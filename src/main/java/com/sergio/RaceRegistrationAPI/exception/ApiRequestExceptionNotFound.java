package com.sergio.RaceRegistrationAPI.exception;

public class ApiRequestExceptionNotFound extends RuntimeException {
    public ApiRequestExceptionNotFound(String message) {
        super(message);
    }
}
