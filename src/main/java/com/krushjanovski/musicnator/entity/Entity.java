package com.krushjanovski.musicnator.entity;

import java.time.Instant;
import java.util.UUID;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Entity {

  @Id
  private String uuid;
  @CreatedDate
  private Instant createdAt;
  @CreatedBy
  private String createdBy;
  @LastModifiedDate
  private Instant updatedAt;
  @LastModifiedBy
  private String updatedBy;

  @PrePersist
  private void assignUuid() {
    if (this.uuid == null) {
      this.uuid = UUID.randomUUID().toString();
    }
  }

  public String getUuid() {
    return uuid;
  }

  public Entity setUuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Entity setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public Entity setCreatedBy(String createdBy) {
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

  public String getUpdatedBy() {
    return updatedBy;
  }

  public Entity setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
    return this;
  }
}
