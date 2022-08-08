package com.carpool.partyMatch.handler;

import java.lang.RuntimeException;
import java.lang.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.carpool.partyMatch.exception.ApiException;
import com.carpool.partyMatch.exception.ErrorResponse;
import com.carpool.partyMatch.exception.ErrorCode;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  // @ExceptionHandler(MethodArgumentNotValidException.class)
  // protected ResponseEntity<String> handleValidationException(MethodArgumentNotValidException e) {
  //   log.error("MethodArgumentNotValidException", e);

  //   return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  // }

  // @ExceptionHandler(RuntimeException.class)
  //   public String handleRuntimeException(final RuntimeException e) {
  //       log.error("handleRuntimeException : {}", e.getMessage());
  //       return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  // }

  /*
     * Developer Custom Exception
     */
    @ExceptionHandler(ApiException.class)
    protected ResponseEntity<ErrorResponse> handleApiException(final ApiException e) {
        log.error("handleApiException: {}", e.getErrorCode());
        return ResponseEntity
                .status(e.getErrorCode().getStatus().value())
                .body(new ErrorResponse(e.getErrorCode()));
    }

    /*
     * HTTP 405 Exception
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(final HttpRequestMethodNotSupportedException e) {
        log.error("handleHttpRequestMethodNotSupportedException: {}", e.getMessage());
        return ResponseEntity
                .status(ErrorCode.METHOD_NOT_ALLOWED.getStatus().value())
                .body(new ErrorResponse(ErrorCode.METHOD_NOT_ALLOWED));
    }

    /*
     * HTTP 500 Exception
     */
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(final Exception e) {
        log.error("handleException: {}", e.getMessage());
        return ResponseEntity
                .status(ErrorCode.INTERNAL_SERVER_ERROR.getStatus().value())
                .body(new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR));
    }

}

