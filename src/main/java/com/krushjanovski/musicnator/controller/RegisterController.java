package com.krushjanovski.musicnator.controller;

import com.krushjanovski.musicnator.dto.RegisterDto;
import com.krushjanovski.musicnator.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

  private final UserService service;

  public RegisterController(UserService service) {
    this.service = service;
  }

  @PostMapping()
  public void register(@RequestBody RegisterDto registerDto) {
    service.createUser(registerDto.getFirstName(), registerDto.getLastName(),
        registerDto.getPassword(), registerDto.getEmail(), registerDto.getPhoneNumber(),
        registerDto.getImageResourceUuid());
  }
}
