package com.example.secondhomework.exception;

public class ProductIsNotExistException extends RuntimeException{
    public ProductIsNotExistException(String message) {
        super(message);
    }
}
