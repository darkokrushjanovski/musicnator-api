package com.krushjanovski.musicnator.service;

import com.krushjanovski.musicnator.entity.User;
import com.krushjanovski.musicnator.exception.ConflictException;
import com.krushjanovski.musicnator.exception.ResourceNotFoundException;
import com.krushjanovski.musicnator.repository.UserRepository;
import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final RoleService roleService;
  private final PasswordEncoder passwordEncoder;

  public UserServiceImpl(UserRepository userRepository, RoleService roleService,
      PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.roleService = roleService;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public void createUser(String firstName, String lastName, String password, String email,
      String phoneNumber, Long roleId) {
    var role = roleService.getRole(roleId);

    userRepository.findByEmail(email).ifPresent((user) -> {
      throw new ConflictException(String.format("Email %s is already taken", email));
    });

    var user = new User().setFirstName(firstName).setLastName(lastName).setEmail(email)
        .setPassword(passwordEncoder.encode(password))
        .setPhoneNumber(phoneNumber).setRole(role);

    userRepository.save(user);
  }

  @Override
  public void updateUser(Long id, String firstName, String lastName, String password,
      String phoneNumber, Long roleId) {
    var role = roleService.getRole(roleId);

    var user = getUser(id);
    user.setFirstName(firstName).setLastName(lastName).setPhoneNumber(phoneNumber).setRole(role);
    if (password != null && !password.isEmpty()) {
      user.setPassword(passwordEncoder.encode(password));
    }

    userRepository.save(user);
  }

  @Override
  public User getUser(Long id) {
    return userRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException(String.format("User with id %d not found", id)));
  }

  @Override
  public List<User> getUsers() {
    return userRepository.findAll();
  }
}
