package com.example.demo.Service.Impl;

import com.example.demo.Entity.Animal;
import com.example.demo.Entity.User;
import com.example.demo.Repository.AnimalRepository;
import com.example.demo.Service.AnimalService;
import com.example.demo.Service.UserService;
import com.example.demo.dto.AnimalDTO;
import com.example.demo.handlerexception.CustomException;
import common.Constant;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService {
  private AnimalRepository animalRepository;
  private UserService userService;

  public AnimalServiceImpl(AnimalRepository animalRepository, UserService userService) {
    this.animalRepository = animalRepository;
    this.userService = userService;
  }

  @Override
  public Animal create(AnimalDTO request) throws CustomException {
    Integer userId = request.getUserId();

    Optional<User> userOpt = userService.findById(userId);
    userOpt.orElseThrow(() -> new CustomException("user not found", Constant.ERROR_TITLE, 1001, HttpStatus.NOT_FOUND));

    Optional<Animal> animalOpt = animalRepository.findByName(request.getName());
    if (animalOpt.isPresent()) {
      throw new CustomException("animal exist", "duplicate", 1001, HttpStatus.CONFLICT);
    }

    Animal animal = new Animal();
    animal.setName(request.getName());
    animal.setUserId(request.getUserId());
    Animal newAnimal = animalRepository.saveAndFlush(animal);
    return newAnimal;
  }

  @Override
  public Animal findById(Integer animalId) throws CustomException{
    Optional<Animal> opt = animalRepository.findById(animalId);
    opt.orElseThrow(() -> new CustomException("animal not found ahihi", Constant.ERROR_TITLE, 1001, HttpStatus.NOT_FOUND));
    return opt.get();
  }

  @Override
  public void delete(Integer animalId) throws CustomException{
    Optional<Animal> opt = animalRepository.findById(animalId);
    opt.orElseThrow(()->new CustomException("item not found", Constant.ERROR_TITLE, 1001, HttpStatus.NOT_FOUND));
    animalRepository.deleteById(animalId);
  }

  @Override
  public Animal update(AnimalDTO request, Integer animalId) throws CustomException{
    Optional<Animal> opt = animalRepository.findById(animalId);
    opt.orElseThrow(()->new CustomException("Animal not found", Constant.ERROR_TITLE, 1001, HttpStatus.NOT_FOUND));

    Animal animal = opt.get();
    animal.setName(request.getName());
    animal.setUserId(request.getUserId());

    Animal animal1 = animalRepository.saveAndFlush(animal);
    return animal1;
  }

  @Override
  public List<Animal> getAllAnimals(){
    return animalRepository.findAll();
  }

  @Override
  public List<Animal> findByUserId(Integer userId){
    return animalRepository.findByUserId(userId);
  }
}