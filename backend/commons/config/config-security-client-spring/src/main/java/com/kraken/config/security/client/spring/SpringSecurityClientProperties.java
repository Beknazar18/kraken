package com.kraken.config.security.client.spring;

import com.kraken.config.security.client.api.SecurityClientProperties;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Value
@Builder
@ConstructorBinding
@ConfigurationProperties("kraken.security")
final class SpringSecurityClientProperties implements SecurityClientProperties {

  @NonNull String url;
  @NonNull String webId;
  @NonNull String apiId;
  @NonNull String apiSecret;
  @NonNull String realm;

}
