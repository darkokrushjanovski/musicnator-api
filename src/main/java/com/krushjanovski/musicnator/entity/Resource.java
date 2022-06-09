package com.krushjanovski.musicnator.entity;

import javax.persistence.Lob;

@javax.persistence.Entity
public class Resource extends Entity {

  private String name;
  private String type;
  @Lob
  private byte[] content;

  public String getName() {
    return name;
  }

  public Resource setName(String name) {
    this.name = name;
    return this;
  }

  public String getType() {
    return type;
  }

  public Resource setType(String type) {
    this.type = type;
    return this;
  }

  public byte[] getContent() {
    return content;
  }

  public Resource setContent(byte[] content) {
    this.content = content;
    return this;
  }
}
