package com.krushjanovski.musicnator.service;

import com.krushjanovski.musicnator.entity.Role;
import com.krushjanovski.musicnator.exception.ResourceNotFoundException;
import com.krushjanovski.musicnator.repository.RoleRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

  private final RoleRepository repository;

  public RoleServiceImpl(RoleRepository repository) {
    this.repository = repository;
  }

  @Override
  public void createRole(String name) {
    Role role = new Role()
        .setName(name);
    repository.save(role);
  }

  @Override
  public Role getRole(String uuid) {
    return repository
        .findById(uuid)
        .orElseThrow(
            () -> new ResourceNotFoundException(
                String.format("Role with uuid %s not found", uuid)));
  }

  @Override
  public List<Role> getRoles() {
    return repository.findAll();
  }

  @Override
  public Role getRoleByName(String name) {
    return repository.findByName(name)
        .orElseThrow(
            () -> new ResourceNotFoundException(
                String.format("Role with name %s not found", name)));
  }
}
