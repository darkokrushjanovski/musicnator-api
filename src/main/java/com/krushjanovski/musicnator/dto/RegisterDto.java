package com.krushjanovski.musicnator.dto;

public class RegisterDto {
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private String password;

  public String getFirstName() {
    return firstName;
  }

  public RegisterDto setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public RegisterDto setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public RegisterDto setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public RegisterDto setPassword(String password) {
    this.password = password;
    return this;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public RegisterDto setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }


}
