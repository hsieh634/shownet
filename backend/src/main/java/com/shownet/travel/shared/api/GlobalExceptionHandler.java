package com.shownet.travel.shared.api;

import jakarta.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.List;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ApiError> handleValidation(
            MethodArgumentNotValidException exception,
            HttpServletRequest request
    ) {
        List<ApiError.FieldError> fieldErrors = exception.getBindingResult().getFieldErrors().stream()
                .map(error -> new ApiError.FieldError(error.getField(), error.getDefaultMessage()))
                .toList();

        ApiError body = new ApiError(
                "VALIDATION_FAILED",
                "Request validation failed.",
                HttpStatus.BAD_REQUEST.value(),
                request.getRequestURI(),
                MDC.get("traceId"),
                Instant.now(),
                fieldErrors
        );
        return ResponseEntity.badRequest().body(body);
    }
}

