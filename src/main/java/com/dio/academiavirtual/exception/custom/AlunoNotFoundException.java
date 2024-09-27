package com.dio.academiavirtual.exception.custom;

public class AlunoNotFoundException extends RuntimeException{
    public AlunoNotFoundException(String message) {
        super(message);
    }
}
