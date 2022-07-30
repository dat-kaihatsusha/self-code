package com.example.demo.Controller;

import com.example.demo.Entity.Animal;
import com.example.demo.Service.AnimalService;
import com.example.demo.dto.AnimalDTO;
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
    Animal response = animalService.create(request);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getAnimal(@PathVariable("id") Integer animalId) {
    Animal response = animalService.findById(animalId);
    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteAnimal(@PathVariable("id") Integer animalId){
    animalService.delete(animalId);
    return ResponseEntity.ok().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@RequestBody AnimalDTO request, @PathVariable("id") Integer animalId){
    Animal animal = animalService.update(request, animalId);
    return ResponseEntity.ok(animal);
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
