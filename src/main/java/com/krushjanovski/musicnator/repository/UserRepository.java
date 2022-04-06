package com.krushjanovski.musicnator.repository;

import com.krushjanovski.musicnator.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

  Optional<User> findByEmail(String email);
}
