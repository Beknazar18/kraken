package com.kraken.runtime.server.properties;

import com.kraken.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RuntimeServerPropertiesConfigurationTest {
  @Autowired
  RuntimeServerProperties serverProperties;

  @Test
  public void shouldCreateProperties() {
    assertThat(serverProperties.getConfigPath()).isNotNull();
  }
}
