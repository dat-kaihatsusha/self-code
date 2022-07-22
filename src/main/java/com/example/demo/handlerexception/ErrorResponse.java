package com.example.demo.handlerexception;

public class ErrorResponse {
  private String message;
  private int errorCode;

  private String title;

  public ErrorResponse(String message, int errorCode, String title) {
    this.message = message;
    this.errorCode = errorCode;
    this.title = title;
  }

  public ErrorResponse(String message, int errorCode) {
    this.message = message;
    this.errorCode = errorCode;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public int getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}