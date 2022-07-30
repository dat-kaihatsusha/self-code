package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.dto.UserDTO;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

public interface UserService {
  User postUser(UserDTO request);

  List<User> getAllUsers();

  User getUserById(int id);

  void deleteUserById(int id);

  User updateUser(int id, String name) throws UserPrincipalNotFoundException;

  Optional<User> findById(Integer userId);
}
