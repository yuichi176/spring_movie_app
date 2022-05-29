package com.example.spring_movie_app.controller;

import com.example.spring_movie_app.repository.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Controller層まで届いた例外のハンドリング処理を実装するクラス。AOPでControllerに組み込まれる。
 */
@RestControllerAdvice
public class ErrorExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * ResourceNotFoundExceptionをハンドリングして404エラーレスポンスに変換する
     * @param ex 例外オブジェクト
     * @param request リクエストデータ
     * @return レスポンス
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleMyException(ResourceNotFoundException ex, WebRequest request) {
        return super.handleExceptionInternal(ex, null, HttpHeaders.EMPTY, HttpStatus.NOT_FOUND, request);
    }

    /**
     * DataIntegrityViolationException(DuplicateKeyException)をハンドリングして409エラーレスポンスに変換する
     * @param ex 例外オブジェクト
     * @param request リクエストデータ
     * @return レスポンス
     */
    @ExceptionHandler
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {
        return super.handleExceptionInternal(ex, null, HttpHeaders.EMPTY, HttpStatus.CONFLICT, request);
    }

    /**
     * 全ての例外をキャッチする。どこにもキャッチされなかったらこれが呼ばれる。
     * @param ex 例外オブジェクト
     * @param request リクエストデータ
     * @return レスポンス
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
        return super.handleExceptionInternal(ex, null, HttpHeaders.EMPTY, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
