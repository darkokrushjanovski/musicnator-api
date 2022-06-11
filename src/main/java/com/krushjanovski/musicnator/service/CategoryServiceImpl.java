package com.krushjanovski.musicnator.service;

import com.krushjanovski.musicnator.entity.Category;
import com.krushjanovski.musicnator.exception.ResourceNotFoundException;
import com.krushjanovski.musicnator.repository.CategoryRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository repository;

  public CategoryServiceImpl(
      CategoryRepository repository) {
    this.repository = repository;
  }

  @Override
  public void createCategory(String name, String description) {
    var category = new Category()
        .setName(name)
        .setDescription(description);

    repository.save(category);
  }

  @Override
  public void updateCategory(String uuid, String name, String description) {
    var category = getCategory(uuid);
    category.setName(name);
    category.setDescription(description);

    repository.save(category);
  }

  @Override
  public void deleteCategory(String uuid) {
    var category = getCategory(uuid);

    repository.delete(category);
  }

  @Override
  public Category getCategory(String uuid) {
    return repository.findById(uuid).orElseThrow(
        () -> new ResourceNotFoundException(String.format("Category with id %s not found", uuid)));
  }

  @Override
  public List<Category> getCategoriesByUuid(List<String> categoryUuids) {
    return repository.findAllById(categoryUuids);
  }

  @Override
  public List<Category> getCategories() {
    return repository.findAll();
  }

  @Override
  public Category getCategoryByTitle(String title) {
    return repository.findByName(title).orElseThrow(
        () -> new ResourceNotFoundException(
            String.format("Category with title %s not found", title)));
  }
}
