package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "item_id")
  Integer itemId;
  @Column(name = "name")
  String name;
  @Column(name = "user_id")
  Integer userId; //userId



  public Item(String name, Integer user_id) {
    this.name = name;
    this.userId = user_id;
  }

  public Item() {
  }

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

  public Integer getItemId() {
    return itemId;
  }

  public void setItemId(Integer itemId) {
    this.itemId = itemId;
  }
}
