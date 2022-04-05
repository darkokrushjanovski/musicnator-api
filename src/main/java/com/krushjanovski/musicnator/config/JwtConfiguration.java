package com.krushjanovski.musicnator.config;

import com.krushjanovski.musicnator.util.JwtUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfiguration {

  @Value("${jwt.secret-key}")
  private String jwtSecretKey;

  @Bean
  public JwtUtils jwtUtils() {
    return new JwtUtils(jwtSecretKey);
  }

}
