package com.example.demo.Service.Impl;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
  @Autowired
  UserRepository userRepository;

  @Override
  public User postUser(String name) {
    User user = new User();
    user.setName(name);
    return userRepository.save(user);
  }

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public User getUserById(int id){
    return userRepository.findById(id).get();
  }

  @Override
  public void deleteUserById(int id){
    userRepository.deleteById(id);
  }

  @Override
  public User updateUser(int id, String name) throws UserPrincipalNotFoundException {
    Optional<User> userOptional = userRepository.findById(id);
    if (userOptional.isPresent()) {
      User user = userOptional.get();
      user.setName(name);
      return userRepository.save(user);
    } else {
      throw new UserPrincipalNotFoundException("User with id " + id + " is not found");
    }
  }
}