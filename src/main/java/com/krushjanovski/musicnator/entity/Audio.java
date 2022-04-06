package com.krushjanovski.musicnator.entity;

import java.util.List;
import javax.persistence.*;

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
  @OneToOne
  private Resource audioResource;
  @OneToOne
  private Resource imageResource;

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

  public Resource getAudioResource() {
    return audioResource;
  }

  public Audio setAudioResource(Resource audioResource) {
    this.audioResource = audioResource;
    return this;
  }

  public Resource getImageResource() {
    return imageResource;
  }

  public Audio setImageResource(Resource imageResource) {
    this.imageResource = imageResource;
    return this;
  }
}
