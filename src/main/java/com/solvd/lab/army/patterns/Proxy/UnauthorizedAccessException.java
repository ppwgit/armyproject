package com.solvd.lab.army.patterns.Proxy;

public class UnauthorizedAccessException extends RuntimeException{
    public UnauthorizedAccessException(String message) {
        super(message);
    }
}
