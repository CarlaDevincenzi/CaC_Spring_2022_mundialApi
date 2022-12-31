package com.cac.mundialapi.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException e){

        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validacionErronea(MethodArgumentNotValidException ex){

        List<String> errores = ex.getBindingResult().getFieldErrors().stream()
                .map(exc -> exc.getDefaultMessage())
                .distinct()
                .collect(Collectors.toList());

        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> integrityViolation(DataIntegrityViolationException ex){

        String error = "Error al intentar la ejecucion. id inexistente.";

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
