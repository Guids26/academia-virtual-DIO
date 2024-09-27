package com.dio.academiavirtual.exception.custom;

public class CpfConflictException extends RuntimeException{
    public CpfConflictException(String message) {
        super(message);
    }
}
