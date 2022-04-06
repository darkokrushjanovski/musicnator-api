package com.krushjanovski.musicnator.dto;

public class RoleDto extends BaseDto {

  private String name;

  public String getName() {
    return name;
  }

  public RoleDto setName(String name) {
    this.name = name;
    return this;
  }
}
