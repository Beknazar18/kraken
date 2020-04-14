package com.kraken.runtime.configuration.session;

import com.kraken.security.authentication.api.AuthenticationMode;
import com.kraken.runtime.client.api.RuntimeClient;
import com.kraken.runtime.client.api.RuntimeClientFactory;
import lombok.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RuntimeClientSessionConfiguration {

  @Bean
  public RuntimeClient runtimeClient(@NonNull final RuntimeClientFactory factory) {
    return factory.create(AuthenticationMode.SESSION);
  }

}