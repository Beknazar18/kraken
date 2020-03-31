package com.kraken.config.security.jwt.spring;

import com.kraken.Application;
import com.kraken.config.security.jwt.api.JwtProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class JwtPropertiesSpringTest {
  @Autowired
  JwtProperties properties;

  @Test
  public void shouldCreateProperties() {
    assertThat(properties.getClaims()).isNotNull();
    assertThat(properties.getClaims().getUsername()).isEqualTo("toto");
  }
}
