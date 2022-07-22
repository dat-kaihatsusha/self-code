package com.example.demo.Service;

import com.example.demo.Entity.User;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

public interface UserService {
  User postUser(String name);

  List<User> getAllUsers();

  User getUserById(int id);

  void deleteUserById(int id);

  User updateUser(int id, String name) throws UserPrincipalNotFoundException;
}
