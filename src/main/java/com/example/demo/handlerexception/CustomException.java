package com.example.demo.handlerexception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

  private String message;
  private String title;
  private int errorCode;

  private HttpStatus status;

  public CustomException(String message,
                         String title,
                         int errorCode,
                         HttpStatus status) {
    this.message = message;
    this.title = title;
    this.errorCode = errorCode;
    this.status = status;
  }

  @Override
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status;
  }
}
