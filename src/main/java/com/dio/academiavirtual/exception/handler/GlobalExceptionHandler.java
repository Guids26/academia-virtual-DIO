package com.dio.academiavirtual.exception.handler;

import com.dio.academiavirtual.exception.custom.AlunoNotFoundException;
import com.dio.academiavirtual.exception.custom.CpfConflictException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AlunoNotFoundException.class)
    private ResponseEntity<String> alunoNotFoundHandler(AlunoNotFoundException ex)  {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(CpfConflictException.class)
    private ResponseEntity<String> cpfConflictExceptionHandler(CpfConflictException ex)  {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

}
