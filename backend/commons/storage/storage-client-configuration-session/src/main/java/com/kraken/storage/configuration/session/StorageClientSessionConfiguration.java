package com.kraken.storage.configuration.session;

import com.kraken.security.authentication.api.AuthenticationMode;
import com.kraken.storage.client.api.StorageClient;
import com.kraken.storage.client.api.StorageClientFactory;
import lombok.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class StorageClientSessionConfiguration {

  @Bean
  public StorageClient storageClient(@NonNull final StorageClientFactory factory) {
    return factory.create(AuthenticationMode.SESSION);
  }

}