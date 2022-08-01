package com.example.demo.Service.Impl;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import com.example.demo.dto.UserDTO;
import com.example.demo.handlerexception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
  @Autowired
  UserRepository userRepository;

  @Override
  public Optional<User> findById(Integer userId) {
    return userRepository.findById(userId);
  }

  @Override
  public User postUser(UserDTO request) throws CustomException {
    List<User> users = userRepository.findByName(request.getName());
    if(users.size() > 1){
      throw new CustomException("user exist", "duplicate", 1001, HttpStatus.CONFLICT);
    }
    User user = new User();
    user.setName(request.getName());
    user.setEmail(request.getEmail());
    user.setPhone(request.getPhone());
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

    Optional<User> opt = Optional.ofNullable(new User());

    userOptional.orElseThrow(() -> new UserPrincipalNotFoundException("User not found"));

    User user = userOptional.get();
    user.setName(name);
    return userRepository.save(user);

  }
}