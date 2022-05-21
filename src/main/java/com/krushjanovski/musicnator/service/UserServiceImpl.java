package com.krushjanovski.musicnator.service;

import com.krushjanovski.musicnator.dto.RegisterDto;
import com.krushjanovski.musicnator.dto.UserDto;
import com.krushjanovski.musicnator.entity.Role;
import com.krushjanovski.musicnator.entity.User;
import com.krushjanovski.musicnator.exception.ConflictException;
import com.krushjanovski.musicnator.exception.ResourceNotFoundException;
import com.krushjanovski.musicnator.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.security.core.context.SecurityContextHolder;
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
      String phoneNumber) {
    var role = roleService.getRoleByName("USER");
    createUser(firstName, lastName, password, email, phoneNumber, role.getUuid());
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

  @Override
  public UserDto getActiveUser() {
    String name = SecurityContextHolder.getContext().getAuthentication().getName();
    Optional<User> user = repository.findByEmail(name);
    UserDto userDto = (UserDto) new UserDto()
        .setFirstName(user.get().getFirstName())
        .setLastName(user.get().getLastName())
        .setPhoneNumber(user.get().getPhoneNumber())
        .setEmail(name)
        .setCreatedAt(user.get().getCreatedAt())
        .setUuid(user.get().getUuid());

    return userDto;
  }
}
