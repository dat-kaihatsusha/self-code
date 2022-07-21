package com.example.demo.Service.Impl;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
  @Autowired
  UserRepository userRepository;

  @Override
  public User postUser(String name){
    User user = new User();
    user.setName(name);
    return userRepository.save(user);
  }
}
