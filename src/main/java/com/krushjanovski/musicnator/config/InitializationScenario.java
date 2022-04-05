package com.krushjanovski.musicnator.config;

import com.krushjanovski.musicnator.entity.Category;
import com.krushjanovski.musicnator.entity.Role;
import com.krushjanovski.musicnator.repository.CategoryRepository;
import com.krushjanovski.musicnator.repository.RoleRepository;
import com.krushjanovski.musicnator.service.UserService;
import java.util.List;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class InitializationScenario implements InitializingBean {

  private final UserService userService;
  private final RoleRepository roleRepository;
  private final CategoryRepository categoryRepository;

  public InitializationScenario(
      UserService userService, RoleRepository roleRepository,
      CategoryRepository categoryRepository) {
    this.userService = userService;
    this.roleRepository = roleRepository;
    this.categoryRepository = categoryRepository;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    if (roleRepository.count() > 0) {
      return;
    }
    var roles = List.of(new Role().setName("ADMIN"), new Role().setName("USER"));
    roles = roleRepository.saveAll(roles);

    userService.createUser("Stefan", "Kondinski", "TEST12345", "kondinskis@gmail.com", "075880950",
        roles.get(0).getId());

    List.of(
            new Category().setName("Hip Hop").setDescription("Hip Hop Description"),
            new Category().setName("Rock").setDescription("Rock Description"))
        .forEach(categoryRepository::save);
  }
}
