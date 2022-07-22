package com.example.demo.Controller;

import com.example.demo.Entity.Item;
import com.example.demo.Service.ItemService;
import com.example.demo.dto.ItemDTO;
import com.example.demo.handlerexception.CustomException;
import com.example.demo.handlerexception.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/items/")
public class ItemController {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  private ItemService itemService;

  public ItemController(ItemService itemService) {
    this.itemService = itemService;
  }

  @PostMapping("")
  public ResponseEntity<?> createItem(@RequestBody ItemDTO request) {
    try {
      Item response = itemService.create(request);
      return ResponseEntity.ok(response);
    } catch (CustomException e) {
      return new ResponseEntity<>(new ErrorResponse(e.getMessage(),
          e.getErrorCode(),
          e.getTitle()),
          e.getStatus());
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getItem(@PathVariable("id") Integer itemId) {
    try {
      Item response = itemService.findById(itemId);
      return ResponseEntity.ok(response);
    } catch (CustomException e) {
      return new ResponseEntity<>(new ErrorResponse(e.getMessage(),
          e.getErrorCode(),
          e.getTitle()),
          e.getStatus());
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteItem(@PathVariable("id") Integer itemId) {
    try {
      itemService.delete(itemId);
      return ResponseEntity.ok().build();
    }catch (CustomException e){
      return new ResponseEntity<>(new ErrorResponse(e.getMessage(), e.getErrorCode(), e.getTitle()), e.getStatus());
    }

  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@RequestBody ItemDTO request, @PathVariable("id") Integer itemId) {
    try {
      Item item = itemService.update(request, itemId);
      return ResponseEntity.ok(item);
    }catch (CustomException e){
      return new ResponseEntity<>(new ErrorResponse(e.getMessage(), e.getErrorCode(), e.getTitle()), e.getStatus());
    }

  }

}
