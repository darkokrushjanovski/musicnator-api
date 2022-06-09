package com.krushjanovski.musicnator.config;

import com.krushjanovski.musicnator.entity.Category;
import com.krushjanovski.musicnator.entity.Role;
import com.krushjanovski.musicnator.service.CategoryService;
import com.krushjanovski.musicnator.service.RoleService;
import com.krushjanovski.musicnator.service.UserService;
import java.util.List;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class InitializationScenario implements InitializingBean {

  private final UserService userService;
  private final RoleService roleService;
  private final CategoryService categoryService;

  public InitializationScenario(UserService userService,
      RoleService roleService, CategoryService categoryService) {
    this.userService = userService;
    this.roleService = roleService;
    this.categoryService = categoryService;
  }


  @Override
  public void afterPropertiesSet() {
    if (!roleService.getRoles().isEmpty()) {
      return;
    }

    var roles = List.of(new Role().setName("ADMIN"), new Role().setName("USER"));
    roles.forEach(role -> roleService.createRole(role.getName()));
    roles = roleService.getRoles();

    userService.createUser("Stefan", "Kondinski", "TEST12345", "kondinskis@gmail.com", "075880950",
<<<<<<< HEAD
        roles.get(0).getUuid(), "Uuid for random image");
=======
        roles.get(0).getUuid(), null);
>>>>>>> 6c32f1d9227ea0cf278295d4f855effc23fcea93

    List.of(
            new Category().setName("Hip Hop").setDescription("Hip Hop Description"),
            new Category().setName("Rock").setDescription("Rock Description"))
        .forEach(category -> categoryService.createCategory(category.getName(),
            category.getDescription()));
  }
}
