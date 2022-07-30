package com.example.demo.Controller;

import com.example.demo.Service.UserService;
import com.example.demo.dto.UserDTO;
import com.example.demo.handlerexception.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  UserService userService;

  @PostMapping()
  public ResponseEntity postUser(@Valid @RequestBody UserDTO request) {
    return ResponseEntity.ok(userService.postUser(request));
  }

  @GetMapping()
  public ResponseEntity getUsers() {
    return ResponseEntity.ok(userService.getAllUsers());
  }

  @GetMapping("/{id}")
  public ResponseEntity getUserById(@PathVariable Integer id) {
    return ResponseEntity.ok(userService.getUserById(id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteUserById(@PathVariable Integer id) {
    userService.deleteUserById(id);
    return ResponseEntity.ok("success");
  }

//  @PutMapping("/{id}")
//  public ResponseEntity updateUser(@PathVariable Integer id, @RequestParam String name) throws UserPrincipalNotFoundException {
//    return ResponseEntity.ok(userService.updateUser(id, name));
//  }

  @PutMapping("/{id}")
  public ResponseEntity updateUser(@PathVariable Integer id, @RequestParam String name) {
    try {
      return ResponseEntity.ok(userService.updateUser(id, name));
    } catch (UserPrincipalNotFoundException e) {
      System.out.println("e day nhe: " + e);
      return ResponseEntity.ok(new ErrorResponse(e.getMessage(), 404));
    }
  }

}
