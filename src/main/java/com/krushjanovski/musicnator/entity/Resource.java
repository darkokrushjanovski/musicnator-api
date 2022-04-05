package com.krushjanovski.musicnator.entity;

import javax.persistence.Lob;

@javax.persistence.Entity
public class Resource extends Entity {

  @Lob
  private byte[] content;

  public byte[] getContent() {
    return content;
  }

  public Resource setContent(byte[] content) {
    this.content = content;
    return this;
  }
}
