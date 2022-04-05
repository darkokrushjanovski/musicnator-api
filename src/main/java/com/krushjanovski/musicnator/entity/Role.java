package com.krushjanovski.musicnator.entity;

@javax.persistence.Entity
public class Role extends Entity {

  private String name;

  public String getName() {
    return name;
  }

  public Role setName(String name) {
    this.name = name;
    return this;
  }
}
