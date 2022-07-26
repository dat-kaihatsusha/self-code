package com.example.demo.dto;

public class AnimalDTO {
  private String name;
  private int userId;

  public AnimalDTO() {
  }

  public AnimalDTO(String name, int userId) {
    this.name = name;
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }
}
