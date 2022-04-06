package com.krushjanovski.musicnator.service;

import com.krushjanovski.musicnator.entity.Role;
import java.util.List;

public interface RoleService {

  void createRole(String name);

  Role getRole(String uuid);

  List<Role> getRoles();
}
