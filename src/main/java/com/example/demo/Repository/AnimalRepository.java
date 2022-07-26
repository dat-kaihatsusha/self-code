package com.example.demo.Repository;

import com.example.demo.Entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
  Optional<Animal> findByName(String name);

  List<Animal> findByUserId(Integer paramUserId);
}
