package com.kraken.analysis.properties.spring;

import com.kraken.analysis.properties.api.GrafanaProperties;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Value
@Builder
@ConstructorBinding
@ConfigurationProperties(prefix = "kraken.grafana")
final class SpringGrafanaProperties implements GrafanaProperties {
  @NonNull String url;
  @NonNull String dashboard;
  @NonNull String user;
  @NonNull String password;
}
