package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "animals")
public class Animal {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "animal_id")
  Integer animalId;
  @Column(name = "name")
  String name;
  @Column(name = "user_id")
  Integer userId;

  public Animal(Integer animalId, String name, Integer userId) {
    this.animalId = animalId;
    this.name = name;
    this.userId = userId;
  }

  public Animal() {
  }

  public Integer getAnimalId() {
    return animalId;
  }

  public void setAnimalId(Integer animalId) {
    this.animalId = animalId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }
}
