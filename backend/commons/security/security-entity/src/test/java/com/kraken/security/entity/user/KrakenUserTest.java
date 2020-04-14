package com.kraken.security.entity.user;

import com.google.common.collect.ImmutableList;
import com.kraken.security.entity.user.KrakenRole;
import com.kraken.security.entity.user.KrakenUser;
import com.kraken.tests.utils.TestUtils;
import org.junit.Test;

import java.time.Instant;

import static java.time.temporal.ChronoUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class KrakenUserTest {

  public static final KrakenUser KRAKEN_USER = KrakenUser.builder()
      .issuedAt(Instant.EPOCH)
      .expirationTime(Instant.EPOCH.plusMillis(1))
      .userId("userId")
      .username("username")
      .roles(ImmutableList.of(KrakenRole.USER))
      .groups(ImmutableList.of("/default-kraken"))
      .currentGroup("/default-kraken")
      .build();

  public static final KrakenUser KRAKEN_ADMIN = KrakenUser.builder()
      .issuedAt(Instant.EPOCH)
      .expirationTime(Instant.EPOCH.plusMillis(1))
      .userId("userId")
      .username("username")
      .roles(ImmutableList.of(KrakenRole.ADMIN))
      .groups(ImmutableList.of("/default-kraken"))
      .currentGroup("/default-kraken")
      .build();

  public static final KrakenUser KRAKEN_API = KrakenUser.builder()
      .issuedAt(Instant.EPOCH)
      .expirationTime(Instant.EPOCH.plusMillis(1))
      .userId("userId")
      .username("username")
      .roles(ImmutableList.of(KrakenRole.API))
      .groups(ImmutableList.of())
      .currentGroup("")
      .build();

  @Test
  public void shouldPassEquals() {
    TestUtils.shouldPassEquals(KRAKEN_USER.getClass());
  }

  @Test
  public void shouldDecodeInstants() {
    final var now = Instant.now();
    final var time = now.toEpochMilli() / 1000; // in seconds
    final var user = new KrakenUser(time,
        time,
        "userId",
        "username",
        null,
        null,
        null);
    assertThat(user.getExpirationTime()).isCloseTo(now, within(1, SECONDS));
    assertThat(user.getIssuedAt()).isCloseTo(now, within(1, SECONDS));
  }

  @Test
  public void shouldPassToString() {
    TestUtils.shouldPassToString(KRAKEN_USER);
  }

}