package com.example.spring_movie_app.repository;

/**
 * 一意制約違反を表すカスタム例外
 */
public class DuplicateKeyException extends RuntimeException {

    public DuplicateKeyException(String message) {
        super(message);
    }

    public DuplicateKeyException(String message, Throwable cause) {
        super(message, cause);
    }
}
