package com.krushjanovski.musicnator.entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@javax.persistence.Entity
public class User extends Entity {

  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private String phoneNumber;

  @ManyToOne
  @JoinColumn(name = "role_id")
  private Role role;

  @OneToOne
  @JoinColumn(name = "resource_uuid")
  private Resource imageResource;


  public String getFirstName() {
    return firstName;
  }

  public User setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public User setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public User setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public User setPassword(String password) {
    this.password = password;
    return this;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public User setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  public Role getRole() {
    return role;
  }

  public User setRole(Role role) {
    this.role = role;
    return this;
  }

  public Resource getImageResource() {
    return imageResource;
  }

  public User setImageResource(Resource imageResource) {
    this.imageResource = imageResource;
    return this;
  }
}
