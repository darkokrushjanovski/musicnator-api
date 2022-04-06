package com.krushjanovski.musicnator.config;

import com.krushjanovski.musicnator.service.AuthService;
import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class AuditingConfiguration {

  @Bean
  public AuditorAware<Long> auditorProvider(AuthService authService) {
    return new AuditorAwareImpl(authService);
  }

  static class AuditorAwareImpl implements AuditorAware<Long> {

    private final AuthService authService;

    AuditorAwareImpl(AuthService authService) {
      this.authService = authService;
    }

    @Override
    public Optional<Long> getCurrentAuditor() {
      return Optional.ofNullable(authService.getAuthenticatedPrincipal())
          .map(authenticatedPrincipal -> authenticatedPrincipal.getUser()
              .getId());
    }
  }
}
