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

  private final UserRepository repository;
  private final RoleService roleService;
  private final PasswordEncoder passwordEncoder;

  public UserServiceImpl(UserRepository repository, RoleService roleService,
      PasswordEncoder passwordEncoder) {
    this.repository = repository;
    this.roleService = roleService;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public void createUser(String firstName, String lastName, String password, String email,
      String phoneNumber, String roleUuid) {
    var role = roleService.getRole(roleUuid);

    repository.findByEmail(email).ifPresent((user) -> {
      throw new ConflictException(String.format("Email %s is already taken", email));
    });

    var user = new User().setFirstName(firstName).setLastName(lastName).setEmail(email)
        .setPassword(passwordEncoder.encode(password))
        .setPhoneNumber(phoneNumber).setRole(role);

    repository.save(user);
  }

  @Override
  public void updateUser(String uuid, String firstName, String lastName, String password,
      String phoneNumber, String roleUuid) {
    var role = roleService.getRole(roleUuid);

    var user = getUser(uuid);
    user.setFirstName(firstName).setLastName(lastName).setPhoneNumber(phoneNumber).setRole(role);
    if (password != null && !password.isEmpty()) {
      user.setPassword(passwordEncoder.encode(password));
    }

    repository.save(user);
  }

  @Override
  public User getUser(String uuid) {
    return repository.findById(uuid).orElseThrow(
        () -> new ResourceNotFoundException(String.format("User with id %s not found", uuid)));
  }

  @Override
  public List<User> getUsers() {
    return repository.findAll();
  }
}
