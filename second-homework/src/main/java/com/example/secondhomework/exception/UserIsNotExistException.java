package com.example.secondhomework.exception;

public class UserIsNotExistException extends RuntimeException{

    public UserIsNotExistException(String message) {
        super(message);
    }
}
