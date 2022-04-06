package com.krushjanovski.musicnator.dto;

import java.util.List;

public class AudioDto extends BaseDto {

  private String title;
  private String description;
  private List<Long> categoryIds;
  private List<CategoryDto> categories;
  private Long audioResourceId;
  private Long imageResourceId;

  public String getTitle() {
    return title;
  }

  public AudioDto setTitle(String title) {
    this.title = title;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public AudioDto setDescription(String description) {
    this.description = description;
    return this;
  }

  public List<Long> getCategoryIds() {
    return categoryIds;
  }

  public AudioDto setCategoryIds(List<Long> categoryIds) {
    this.categoryIds = categoryIds;
    return this;
  }

  public List<CategoryDto> getCategories() {
    return categories;
  }

  public AudioDto setCategories(
      List<CategoryDto> categories) {
    this.categories = categories;
    return this;
  }

  public Long getAudioResourceId() {
    return audioResourceId;
  }

  public AudioDto setAudioResourceId(Long audioResourceId) {
    this.audioResourceId = audioResourceId;
    return this;
  }

  public Long getImageResourceId() {
    return imageResourceId;
  }

  public AudioDto setImageResourceId(Long imageResourceId) {
    this.imageResourceId = imageResourceId;
    return this;
  }
}
