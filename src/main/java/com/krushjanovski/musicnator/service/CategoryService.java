package com.krushjanovski.musicnator.service;

import com.krushjanovski.musicnator.entity.Category;
import java.util.List;

public interface CategoryService {

  void createCategory(String name, String description);

  void updateCategory(Long id, String name, String description);

  void deleteCategory(Long id);

  Category getCategory(Long id);

  List<Category> getCategories();
}
