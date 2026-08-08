package com.alex.flight_watch.controllers;

import com.alex.flight_watch.dto.ErrorResponse;
import com.alex.flight_watch.exceptions.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> exceptionNotFoundHandler(NotFoundException ex, HttpServletRequest request) {
        ErrorResponse response = new ErrorResponse();
        response.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
        response.setMessage(ex.getMessage());
        response.setPath(request.getRequestURI());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setTimeStamp(LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(response);

    }

    @ExceptionHandler(RestClientException.class)
    public ResponseEntity<ErrorResponse> exceptionBadGatewayHandler(RestClientException ex, HttpServletRequest request) {
        ErrorResponse response = new ErrorResponse();
        response.setError("Bad Gateway");
        response.setMessage("Failed to fetch telemetry from external weather service: " + ex.getMessage());
        response.setPath(request.getRequestURI());
        response.setStatus(HttpStatus.BAD_GATEWAY.value());
        response.setTimeStamp(LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_GATEWAY.value()).body(response);
    }
}

