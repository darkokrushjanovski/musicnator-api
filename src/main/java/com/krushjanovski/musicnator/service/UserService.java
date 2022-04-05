package com.krushjanovski.musicnator.service;

import com.krushjanovski.musicnator.entity.User;

import java.util.List;

public interface UserService {

  void createUser(String firstName, String lastName, String password, String email,
      String phoneNumber, Long roleId);

  void updateUser(Long id, String firstName, String lastName, String password, String phoneNumber,
      Long roleId);

  User getUser(Long id);

  List<User> getUsers();
}
