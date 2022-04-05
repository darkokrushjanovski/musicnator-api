package com.krushjanovski.musicnator.controller;

import com.krushjanovski.musicnator.dto.UserDto;
import com.krushjanovski.musicnator.mapper.UserMapper;
import com.krushjanovski.musicnator.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
        userDto.getEmail(), userDto.getPhoneNumber(), userDto.getRoleId());
  }

  @PutMapping("/{id}")
  public void updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
    service.updateUser(id, userDto.getFirstName(), userDto.getLastName(), userDto.getPassword(),
        userDto.getPhoneNumber(), userDto.getRoleId());
  }

  @GetMapping("/{id}")
  public UserDto getUser(@PathVariable Long id) {
    return mapper.map(service.getUser(id));
  }

  @GetMapping
  public List<UserDto> getUsers() {
    return service.getUsers().stream().map(mapper::map).toList();
  }
}
