package com.example.demo.handlerexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

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

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public List<ErrorResponse> handleValidationExceptions(
      MethodArgumentNotValidException ex) {
    List<ErrorResponse> errors = new ArrayList<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.add(new ErrorResponse(fieldName, HttpStatus.BAD_REQUEST.value(), errorMessage));
      System.out.println("errors: " + errors);
    });
    return errors;
  }

}
