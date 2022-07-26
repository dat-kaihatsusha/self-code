package com.example.demo.Controller;

import com.example.demo.Entity.Animal;
import com.example.demo.Service.AnimalService;
import com.example.demo.dto.AnimalDTO;
import com.example.demo.handlerexception.CustomException;
import com.example.demo.handlerexception.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/animals")
public class AnimalController {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  private AnimalService animalService;

  public AnimalController(AnimalService animalService) {
    this.animalService = animalService;
  }

  @PostMapping("")
  public ResponseEntity<?> createAnimal(@RequestBody AnimalDTO request) {
    try {
      Animal response = animalService.create(request);
      return ResponseEntity.ok(response);
    } catch (CustomException e) {
      return new ResponseEntity<>(new ErrorResponse(e.getMessage(), e.getErrorCode(), e.getTitle()), e.getStatus());
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getAnimal(@PathVariable("id") Integer animalId){
    try{
      Animal response = animalService.findById(animalId);
      return ResponseEntity.ok(response);
    }catch (CustomException e){
      return new ResponseEntity<>(new ErrorResponse(e.getMessage(),
          e.getErrorCode(),
          e.getTitle()),
          e.getStatus());
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteAnimal(@PathVariable("id") Integer animalId){
    try{
      animalService.delete(animalId);
      return ResponseEntity.ok().build();
    }catch (CustomException e){
      return new ResponseEntity<>(new ErrorResponse(e.getMessage(), e.getErrorCode(), e.getTitle()), e.getStatus());
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@RequestBody AnimalDTO request, @PathVariable("id") Integer animalId){
    try{
      Animal animal = animalService.update(request, animalId);
      return ResponseEntity.ok(animal);
    }catch (CustomException e){
      return new ResponseEntity<>(new ErrorResponse(e.getMessage(), e.getErrorCode(), e.getTitle()), e.getStatus());
    }
  }

  @GetMapping("")
  public List<Animal> getListAnimals(){
    return animalService.getAllAnimals();
  }

  @GetMapping("/")
  public List<Animal> findAnimalsByUserId(@RequestParam("userId") Integer userId){
    return animalService.findByUserId(userId);
  }

}
