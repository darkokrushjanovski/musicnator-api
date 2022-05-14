package com.krushjanovski.musicnator.controller;

import com.krushjanovski.musicnator.dto.UserDto;
import com.krushjanovski.musicnator.mapper.UserMapper;
import com.krushjanovski.musicnator.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService service;
  private final UserMapper mapper;

  public UserController(UserService service, UserMapper mapper) {
    this.service = service;
    this.mapper = mapper;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void createUser(@RequestBody UserDto userDto) {
    service.createUser(userDto.getFirstName(), userDto.getLastName(), userDto.getPassword(),
        userDto.getEmail(), userDto.getPhoneNumber(), userDto.getRoleUuid());
  }

  @PutMapping("/{uuid}")
  public void updateUser(@PathVariable String uuid, @RequestBody UserDto userDto) {
    service.updateUser(uuid, userDto.getFirstName(), userDto.getLastName(), userDto.getPassword(),
        userDto.getPhoneNumber(), userDto.getRoleUuid());
  }

  @GetMapping("/{uuid}")
  public UserDto getUser(@PathVariable String uuid) {
    return mapper.map(service.getUser(uuid));
  }

  @GetMapping
  public List<UserDto> getUsers() {
    return service.getUsers().stream().map(mapper::map).collect(Collectors.toList());
  }
  @GetMapping("/activeUser")
  public UserDto getCurrentSessionUser(){
    return service.getActiveUser();
  }
}
