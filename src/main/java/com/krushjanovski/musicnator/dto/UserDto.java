package com.krushjanovski.musicnator.dto;

public class UserDto extends BaseDto {

  private String firstName;
  private String lastName;
  private String password;
  private String email;
  private String phoneNumber;
  private Long roleId;
  private RoleDto role;

  public String getFirstName() {
    return firstName;
  }

  public UserDto setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public UserDto setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public UserDto setPassword(String password) {
    this.password = password;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public UserDto setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public UserDto setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  public Long getRoleId() {
    return roleId;
  }

  public UserDto setRoleId(Long roleId) {
    this.roleId = roleId;
    return this;
  }

  public RoleDto getRole() {
    return role;
  }

  public UserDto setRole(RoleDto role) {
    this.role = role;
    return this;
  }
}
