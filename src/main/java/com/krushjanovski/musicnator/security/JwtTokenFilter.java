package com.krushjanovski.musicnator.security;


import static org.springframework.util.ObjectUtils.isEmpty;

import com.krushjanovski.musicnator.service.UserDetailsService;
import com.krushjanovski.musicnator.util.JwtUtils;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

  private final UserDetailsService userDetailsService;
  private final JwtUtils jwtUtils;

  public JwtTokenFilter(UserDetailsService userDetailsService,
      JwtUtils jwtUtils) {
    this.userDetailsService = userDetailsService;
    this.jwtUtils = jwtUtils;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filter) throws ServletException, IOException {
    final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
    if (isEmpty(header) || !header.startsWith("Bearer ")) {
      filter.doFilter(request, response);
      return;
    }

    final String token = header.split(" ")[1].trim();
    if (!jwtUtils.validate(token)) {
      filter.doFilter(request, response);
      return;
    }

    UserDetails userDetails = userDetailsService.loadUserByUsername(jwtUtils.getUsername(token));

    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
        userDetails, null, userDetails.getAuthorities());

    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    filter.doFilter(request, response);
  }
}
