package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item {
  @Id
  Integer id;
  @Column(name = "user_id")
  Integer userId; //userId
  @Column(name = "name")
  String name;

  public Item(String name, Integer user_id) {
    this.name = name;
    this.userId = user_id;
  }

  public Item() {}

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
