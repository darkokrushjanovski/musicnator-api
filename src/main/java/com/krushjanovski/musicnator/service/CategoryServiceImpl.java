package com.krushjanovski.musicnator.service;

import com.krushjanovski.musicnator.entity.Category;
import com.krushjanovski.musicnator.exception.ResourceNotFoundException;
import com.krushjanovski.musicnator.repository.CategoryRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository categoryRepository;

  public CategoryServiceImpl(
      CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Override
  public void createCategory(String name, String description) {
    var category = new Category()
        .setName(name)
        .setDescription(description);

    categoryRepository.save(category);
  }

  @Override
  public void updateCategory(Long id, String name, String description) {
    var category = getCategory(id);
    category.setName(name);
    category.setDescription(description);

    categoryRepository.save(category);
  }

  @Override
  public void deleteCategory(Long id) {
    var category = getCategory(id);

    categoryRepository.delete(category);
  }

  @Override
  public Category getCategory(Long id) {
    return categoryRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException(String.format("Category with id %d not found", id)));
  }

  @Override
  public List<Category> getCategories() {
    return categoryRepository.findAll();
  }
}
