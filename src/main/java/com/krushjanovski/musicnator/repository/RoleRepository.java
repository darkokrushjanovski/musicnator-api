package com.krushjanovski.musicnator.repository;

import com.krushjanovski.musicnator.entity.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {

  Optional<Role> findByName(String name);

}
