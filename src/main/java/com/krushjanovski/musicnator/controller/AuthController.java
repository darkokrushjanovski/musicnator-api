package com.krushjanovski.musicnator.controller;

import com.krushjanovski.musicnator.dto.LoginDto;
import com.krushjanovski.musicnator.dto.TokenDto;
import com.krushjanovski.musicnator.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final AuthService authService;

  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  @PostMapping("/login")
  public TokenDto login(@RequestBody LoginDto loginDto) {
    return new TokenDto().setAccessToken(
        authService.login(loginDto.getEmail(), loginDto.getPassword()));
  }
}
