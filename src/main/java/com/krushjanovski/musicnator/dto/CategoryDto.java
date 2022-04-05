package com.krushjanovski.musicnator.dto;

public class CategoryDto extends BaseDto {

  private String name;
  private String description;

  public String getName() {
    return name;
  }

  public CategoryDto setName(String name) {
    this.name = name;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public CategoryDto setDescription(String description) {
    this.description = description;
    return this;
  }
}
