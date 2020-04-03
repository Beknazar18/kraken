package com.kraken.runtime.context.entity;

import com.google.common.collect.ImmutableList;
import com.google.common.testing.NullPointerTester;
import com.kraken.runtime.entity.environment.ExecutionEnvironmentEntry;
import com.kraken.runtime.entity.environment.ExecutionEnvironmentEntryTest;
import com.kraken.runtime.entity.task.TaskType;
import com.kraken.tests.utils.TestUtils;
import org.junit.Test;

import java.util.List;
import java.util.function.Function;

import static com.google.common.testing.NullPointerTester.Visibility.PACKAGE;
import static org.assertj.core.api.Assertions.assertThat;

public class ExecutionContextBuilderTest {

  public static final Function<List<ExecutionEnvironmentEntry>, ExecutionContextBuilder> WITH_ENTRIES = (List<ExecutionEnvironmentEntry> entries) -> ExecutionContextBuilder.builder()
      .applicationId("application")
      .taskId("taskId")
      .taskType(TaskType.GATLING_RUN)
      .description("description")
      .file("file")
      .containersCount(42)
      .hostIds(ImmutableList.of("hostId", "other"))
      .entries(entries)
      .build();

  public static final ExecutionContextBuilder EXECUTION_CONTEXT_BUILDER = WITH_ENTRIES.apply(ImmutableList.of(ExecutionEnvironmentEntryTest.EXECUTION_ENVIRONMENT_ENTRY));

  @Test
  public void shouldPassTestUtils() {
    TestUtils.shouldPassEquals(EXECUTION_CONTEXT_BUILDER.getClass());
    new NullPointerTester().setDefault(ExecutionEnvironmentEntry.class, ExecutionEnvironmentEntryTest.EXECUTION_ENVIRONMENT_ENTRY).testConstructors(EXECUTION_CONTEXT_BUILDER.getClass(), PACKAGE);
    TestUtils.shouldPassToString(EXECUTION_CONTEXT_BUILDER);
  }

  @Test
  public void shouldWither() {
    final var context = EXECUTION_CONTEXT_BUILDER.addEntries(ImmutableList.of(ExecutionEnvironmentEntryTest.EXECUTION_ENVIRONMENT_ENTRY));
    assertThat(context.getEntries().size()).isEqualTo(2);
  }

}
