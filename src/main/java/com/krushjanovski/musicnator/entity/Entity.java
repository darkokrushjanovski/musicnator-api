package com.krushjanovski.musicnator.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Entity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @CreatedDate
  private Instant createdAt;
  @LastModifiedDate
  private Instant updatedAt;

  public Long getId() {
    return id;
  }

  public Entity setId(Long id) {
    this.id = id;
    return this;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Entity setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public Entity setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }
}
