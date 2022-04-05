package com.krushjanovski.musicnator.service;

import com.krushjanovski.musicnator.entity.User;
import com.krushjanovski.musicnator.repository.UserRepository;
import java.util.Set;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements
    org.springframework.security.core.userdetails.UserDetailsService {

  private final UserRepository userRepository;

  public UserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByEmail(username)
        .orElseThrow(() -> new UsernameNotFoundException(username));

    return new org.springframework.security.core.userdetails.User(user.getEmail(),
        user.getPassword(), Set.of(new SimpleGrantedAuthority(user.getRole().getName())));
  }
}