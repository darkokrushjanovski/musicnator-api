package com.krushjanovski.musicnator.dto;

import java.util.List;

public class AudioDto extends BaseDto {

  private String title;
  private String description;
  private List<String> categoryUuids;
  private List<CategoryDto> categories;
  private String audioResourceUuid;
  private String imageResourceUuid;
  private UserDto user;

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

  public List<String> getCategoryUuids() {
    return categoryUuids;
  }

  public AudioDto setCategoryUuids(List<String> categoryUuids) {
    this.categoryUuids = categoryUuids;
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

  public String getAudioResourceUuid() {
    return audioResourceUuid;
  }

  public AudioDto setAudioResourceUuid(String audioResourceUuid) {
    this.audioResourceUuid = audioResourceUuid;
    return this;
  }

  public String getImageResourceUuid() {
    return imageResourceUuid;
  }

  public AudioDto setImageResourceUuid(String imageResourceUuid) {
    this.imageResourceUuid = imageResourceUuid;
    return this;
  }

  public UserDto getUser() {
    return user;
  }

  public AudioDto setUser(UserDto user) {
    this.user = user;
    return this;
  }
}
