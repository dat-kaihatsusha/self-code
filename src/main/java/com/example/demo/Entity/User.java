package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;
  @Column(name = "name")
  String name;

  public User(String name) {
    this.name = name;
  }

  public User() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}