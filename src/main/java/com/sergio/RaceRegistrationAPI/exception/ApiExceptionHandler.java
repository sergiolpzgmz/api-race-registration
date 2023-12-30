package com.sergio.RaceRegistrationAPI.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApiExceptionHandler {

    /**
     * Handles ApiRequestExceptionNotFound and returns a ResponseEntity with a corresponding ApiException.
     */
    @ExceptionHandler(value = ApiRequestExceptionNotFound.class)
    public ResponseEntity<Object> handleApiNotFoundRequestException(
            ApiRequestExceptionNotFound apiRequestExceptionNotFound, HttpServletRequest httpServletRequest) {

        ApiException apiException = getApiException(apiRequestExceptionNotFound, httpServletRequest);
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles ApiRequestExceptionBadRequest and returns a ResponseEntity with a corresponding ApiException.
     */
    @ExceptionHandler(value = ApiRequestExceptionBadRequest.class)
    public ResponseEntity<Object> handleApiBadRequestException(
            ApiRequestExceptionBadRequest apiRequestExceptionBadRequest, HttpServletRequest httpServletRequest) {

        ApiException apiException = getApiException(apiRequestExceptionBadRequest, httpServletRequest);
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles HttpMessageNotReadableException and returns a ResponseEntity with a body containing error details.
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex, HttpServletRequest request) {

        Map<String, Object> body = new HashMap<>();
        body.put("message", ex.getMessage());
        body.put("status", HttpStatus.BAD_REQUEST);
        body.put("timestamp", ZonedDateTime.now());
        body.put("path", request.getRequestURL());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles DataIntegrityViolationException and returns a ResponseEntity with a body containing error details.
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleDataIntegrityViolationException(
            DataIntegrityViolationException ex, HttpServletRequest request) {

        String message = ex.getMessage();
        String[] parts = message.split("\\.");
        String missingAttribute = parts[parts.length - 1];

        Map<String, Object> body = new HashMap<>();
        body.put("message", "No value for the attribute " + missingAttribute);
        body.put("status", HttpStatus.BAD_REQUEST);
        body.put("timestamp", ZonedDateTime.now());
        body.put("path", request.getRequestURL());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    /**
     * Generates and returns an ApiException based on the provided exception and HttpServletRequest.
     */
    private static ApiException getApiException(Exception exception, HttpServletRequest httpServletRequest) {
        ApiException apiException = new ApiException(
                exception.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now(ZoneId.systemDefault()),
                httpServletRequest.getRequestURL().toString()
        );
        return apiException;
    }
}



