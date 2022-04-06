package com.krushjanovski.musicnator.service;

import com.krushjanovski.musicnator.entity.User;
import com.krushjanovski.musicnator.repository.UserRepository;
import com.krushjanovski.musicnator.security.AuthenticatedPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements
    org.springframework.security.core.userdetails.UserDetailsService {

  private final UserRepository repository;

  public UserDetailsService(UserRepository repository) {
    this.repository = repository;
  }

  @Override
  public AuthenticatedPrincipal loadUserByUsername(String username)
      throws UsernameNotFoundException {
    User user = repository.findByEmail(username)
        .orElseThrow(() -> new UsernameNotFoundException(username));

    return new AuthenticatedPrincipal(user);
  }
}