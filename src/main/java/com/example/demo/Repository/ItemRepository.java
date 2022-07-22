package com.example.demo.Repository;

import com.example.demo.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
  Optional<Item> findByName(String name);
//  @Query(value = "SELECT id from items where name = :paramName", nativeQuery = true)
//  Integer findIdByName(@Param("paramName") String paramName);
}