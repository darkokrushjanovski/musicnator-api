package com.krushjanovski.musicnator.dto;

public class TokenDto {

  private String accessToken;

  public String getAccessToken() {
    return accessToken;
  }

  public TokenDto setAccessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }
}
