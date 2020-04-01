package com.kraken.security.authentication.jwt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import reactor.core.publisher.Mono;

@Slf4j
@Configuration
class JwtConfiguration {

  @Bean
  public Mono<SecurityContext> securityContext() {
    return ReactiveSecurityContextHolder.getContext();
  }
}
