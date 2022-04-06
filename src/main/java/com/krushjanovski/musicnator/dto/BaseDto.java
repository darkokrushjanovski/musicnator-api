package com.krushjanovski.musicnator.dto;

import java.time.Instant;

public class BaseDto {

  private String uuid;
  private Instant createdAt;
  private Instant updatedAt;

  public String getUuid() {
    return uuid;
  }

  public BaseDto setUuid(String uuid) {
    this.uuid = uuid;
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
