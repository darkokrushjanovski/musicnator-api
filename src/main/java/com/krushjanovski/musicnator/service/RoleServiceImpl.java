package com.krushjanovski.musicnator.service;

import com.krushjanovski.musicnator.entity.Role;
import com.krushjanovski.musicnator.exception.ResourceNotFoundException;
import com.krushjanovski.musicnator.repository.RoleRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

  private final RoleRepository roleRepository;

  public RoleServiceImpl(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @Override
  public Role getRole(Long id) {
    return roleRepository
        .findById(id)
        .orElseThrow(
            () -> new ResourceNotFoundException(String.format("Role with id %d not found", id)));
  }

  @Override
  public List<Role> getRoles() {
    return roleRepository.findAll();
  }
}
