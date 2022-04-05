package com.krushjanovski.musicnator.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class JwtUtils {

  private final String secretKey;

  public JwtUtils(String secretKey) {
    this.secretKey = secretKey;
  }

  public String generate(User user) {
    Date issuedAt = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    Date expiresAt = Date.from(
        LocalDateTime.now().plusDays(1).atZone(ZoneId.systemDefault()).toInstant());
    return Jwts.builder().setSubject(user.getUsername()).setIssuedAt(issuedAt)
        .setExpiration(expiresAt).claim("roles", user.getAuthorities().stream().map(
            GrantedAuthority::getAuthority).collect(Collectors.toList())).signWith(
            SignatureAlgorithm.HS512, secretKey).compact();
  }

  public boolean validate(String token) {
    try {
      Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
      return true;
    } catch (Exception ignore) {
    }
    return false;
  }

  public String getUsername(String token) {
    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
  }
}
