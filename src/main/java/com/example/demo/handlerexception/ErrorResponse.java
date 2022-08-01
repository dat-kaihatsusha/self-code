package com.example.demo.handlerexception;

import lombok.Data;

@Data
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

}