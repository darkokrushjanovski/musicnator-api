package com.krushjanovski.musicnator.service;

import com.krushjanovski.musicnator.entity.Role;
import java.util.List;

public interface RoleService {

  Role getRole(Long id);

  List<Role> getRoles();
}
