package com.krushjanovski.musicnator.controller;

import com.krushjanovski.musicnator.dto.CategoryDto;
import com.krushjanovski.musicnator.mapper.CategoryMapper;
import com.krushjanovski.musicnator.service.CategoryService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

  private final CategoryService service;
  private final CategoryMapper mapper;

  public CategoryController(CategoryService service,
      CategoryMapper mapper) {
    this.service = service;
    this.mapper = mapper;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void createCategory(@RequestBody CategoryDto categoryDto) {
    service.createCategory(categoryDto.getName(), categoryDto.getDescription());
  }

  @PutMapping("/{id}")
  public void updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
    service.updateCategory(id, categoryDto.getName(), categoryDto.getDescription());
  }

  @DeleteMapping("/{id}")
  public void deleteCategory(@PathVariable Long id) {
    service.deleteCategory(id);
  }

  @GetMapping("/{id}")
  public CategoryDto getCategory(@PathVariable Long id) {
    return mapper.map(service.getCategory(id));
  }

  @GetMapping
  public List<CategoryDto> getCategories() {
    return service.getCategories().stream().map(mapper::map).collect(Collectors.toList());
  }
}
