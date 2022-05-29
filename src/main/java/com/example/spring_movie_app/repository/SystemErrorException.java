package com.example.spring_movie_app.repository;

/**
 * システム例外
 */
public class SystemErrorException extends RuntimeException {
    public SystemErrorException(String message) {
        super(message);
    }

    public SystemErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
