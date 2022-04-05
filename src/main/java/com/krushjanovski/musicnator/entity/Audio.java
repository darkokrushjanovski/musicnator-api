package com.krushjanovski.musicnator.entity;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@javax.persistence.Entity
public class Audio extends Entity {

  private String title;
  private String description;
  @ManyToMany
  @JoinTable(
      name = "audio_category",
      joinColumns = @JoinColumn(name = "audio_id"),
      inverseJoinColumns = @JoinColumn(name = "category_id"))
  private List<Category> categories;

  //TODO: music file


  public String getTitle() {
    return title;
  }

  public Audio setTitle(String title) {
    this.title = title;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public Audio setDescription(String description) {
    this.description = description;
    return this;
  }

  public List<Category> getCategories() {
    return categories;
  }

  public Audio setCategories(List<Category> categories) {
    this.categories = categories;
    return this;
  }
}
