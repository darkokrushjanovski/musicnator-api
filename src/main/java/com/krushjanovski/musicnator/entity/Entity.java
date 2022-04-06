package com.krushjanovski.musicnator.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
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
  @CreatedBy
  private Long createdBy;
  @LastModifiedDate
  private Instant updatedAt;
  @LastModifiedBy
  private Long updatedBy;

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

  public Long getCreatedBy() {
    return createdBy;
  }

  public Entity setCreatedBy(Long createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public Entity setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  public Long getUpdatedBy() {
    return updatedBy;
  }

  public Entity setUpdatedBy(Long updatedBy) {
    this.updatedBy = updatedBy;
    return this;
  }
}
