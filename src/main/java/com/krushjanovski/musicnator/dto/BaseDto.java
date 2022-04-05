package com.krushjanovski.musicnator.dto;

import java.time.Instant;

public class BaseDto {

  private Long id;
  private Instant createdAt;
  private Instant updatedAt;

  public Long getId() {
    return id;
  }

  public BaseDto setId(Long id) {
    this.id = id;
    return this;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public BaseDto setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public BaseDto setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }
}
