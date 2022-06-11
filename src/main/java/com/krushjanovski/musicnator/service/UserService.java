package com.krushjanovski.musicnator.service;

import com.krushjanovski.musicnator.dto.RegisterDto;
import com.krushjanovski.musicnator.dto.UserDto;
import com.krushjanovski.musicnator.entity.User;
import java.util.List;

public interface UserService {

  void createUser(String firstName, String lastName, String password, String email,
      String phoneNumber, String imageResourceUuid);

  void createUser(String firstName, String lastName, String password, String email,
      String phoneNumber, String roleUuid, String imageResourceUuid);

  void updateUser(String uuid, String firstName, String lastName, String password,
      String phoneNumber, String roleUuid);

  User getUser(String uuid);

  List<User> getUsers();

  UserDto getActiveUser();
}
