package com.xxwelldone.workshopmongo.controller.exception;

import com.xxwelldone.workshopmongo.model.exception.StandardError;
import com.xxwelldone.workshopmongo.service.exception.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.Instant;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardError> notFound(
            NotFoundException e, HttpServletRequest request
    ) {
        String error = "Not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(
                Instant.now(), status, error, e.getMessage(), request.getRequestURI()
        );
return ResponseEntity.status(status).body(err);
    }
}
