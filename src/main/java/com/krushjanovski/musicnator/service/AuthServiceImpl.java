package com.krushjanovski.musicnator.service;

import com.krushjanovski.musicnator.security.AuthenticatedPrincipal;
import com.krushjanovski.musicnator.util.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
  public AuthenticatedPrincipal getAuthenticatedPrincipal() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    if (authentication == null || !authentication.isAuthenticated()) {
      return null;
    }
    return ((AuthenticatedPrincipal) authentication.getPrincipal());
  }

  @Override
  public String login(String email, String password) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(email, password));

    AuthenticatedPrincipal authenticatedPrincipal = (AuthenticatedPrincipal) authentication.getPrincipal();

    return jwtUtils.generate(authenticatedPrincipal);
  }
}
