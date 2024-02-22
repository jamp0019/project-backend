package com.zeus.projectbackend.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class HandlerException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MissingPathVariableException.class, MethodArgumentTypeMismatchException.class})
    public ResponseEntity<?> handleValidationExceptions(
            Exception ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", ex.getMessage());
        log.error("Unexpected error: ".concat(ex.getMessage()));
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(InternalServerErrorCustom.class)
    public ResponseEntity<?> internalServerException(Exception ex){
        Map<String, Object> response = new HashMap<>();
        response.put("message", ex.getMessage());
        log.error("Unexpected error: ".concat(ex.getMessage()));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

}
