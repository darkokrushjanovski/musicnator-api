package com.krushjanovski.musicnator.service;

import com.krushjanovski.musicnator.entity.Category;
import java.util.List;

public interface CategoryService {

  void createCategory(String name, String description);

  void updateCategory(String uuid, String name, String description);

  void deleteCategory(String uuid);

  Category getCategory(String uuid);

  List<Category> getCategoriesByUuid(List<String> categoryUuids);

  List<Category> getCategories();
}
