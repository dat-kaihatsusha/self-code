package com.example.demo.handlerexception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerException {

//  @ExceptionHandler({CustomException.class})
//  public ResponseEntity<ErrorResponse> handleException(CustomException e) {
//    return new ResponseEntity<>(new ErrorResponse(e.getMessage(),
//        e.getErrorCode(),
//        e.getTitle()),
//        HttpStatus.BAD_REQUEST);
//  }

  @ExceptionHandler({CustomException.class})
  public ResponseEntity<ErrorResponse> handleException(CustomException e) {
    return new ResponseEntity<>(new ErrorResponse(e.getMessage(),
        e.getErrorCode(),
        e.getTitle()),
        e.getStatus());
  }

}
