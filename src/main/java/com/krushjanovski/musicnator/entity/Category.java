package com.krushjanovski.musicnator.entity;

import javax.persistence.ManyToMany;
import java.util.List;

@javax.persistence.Entity
public class Category extends Entity {

  private String name;
  private String description;
  @ManyToMany(mappedBy = "categories")
  private List<Audio> audios;

  public String getName() {
    return name;
  }

  public Category setName(String name) {
    this.name = name;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public Category setDescription(String description) {
    this.description = description;
    return this;
  }

  public List<Audio> getAudios() {
    return audios;
  }

  public Category setAudios(List<Audio> audios) {
    this.audios = audios;
    return this;
  }
}
