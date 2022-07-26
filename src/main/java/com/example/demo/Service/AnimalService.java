package com.example.demo.Service;

import com.example.demo.Entity.Animal;
import com.example.demo.dto.AnimalDTO;

import java.util.List;

public interface AnimalService {
  Animal create(AnimalDTO request);

  Animal findById(Integer animalId);

  void delete(Integer animalId);

  Animal update(AnimalDTO request, Integer itemId);

  List<Animal> getAllAnimals();

  List<Animal> findByUserId(Integer userId);

}
