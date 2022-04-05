package com.krushjanovski.musicnator.service;

import com.krushjanovski.musicnator.util.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

  private final AuthenticationManager authenticationManager;
  private final JwtUtils jwtUtils;

  public AuthServiceImpl(
      AuthenticationManager authenticationManager,
      JwtUtils jwtUtils) {
    this.authenticationManager = authenticationManager;
    this.jwtUtils = jwtUtils;
  }

  @Override
  public String login(String email, String password) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(email, password));

    User user = (User) authentication.getPrincipal();

    return jwtUtils.generate(user);
  }
}
