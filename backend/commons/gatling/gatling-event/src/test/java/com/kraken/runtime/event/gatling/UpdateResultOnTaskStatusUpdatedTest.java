package com.kraken.runtime.event.gatling;

import com.kraken.analysis.client.api.AnalysisClient;
import com.kraken.analysis.entity.ResultStatus;
import com.kraken.runtime.entity.task.ContainerStatus;
import com.kraken.runtime.event.TaskStatusUpdatedEvent;
import com.kraken.runtime.event.TaskStatusUpdatedEventTest;
import com.kraken.tools.event.bus.EventBus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class UpdateResultOnTaskStatusUpdatedTest {

  @Mock
  AnalysisClient analysisClient;

  @Mock
  Function<ContainerStatus, ResultStatus> taskStatusToResultStatus;

  @Mock
  EventBus eventBus;

  UpdateResultOnTaskStatusUpdated listener;

  @Before
  public void before(){
    given(eventBus.of(TaskStatusUpdatedEvent.class)).willReturn(Flux.empty());
    listener = new UpdateResultOnTaskStatusUpdated(eventBus, analysisClient, taskStatusToResultStatus);
  }

  @Test
  public void shouldHandleEvent(){
    final var event = TaskStatusUpdatedEventTest.TASK_STATUS_UPDATED_EVENT;
    final var task = event.getTask();
    given(taskStatusToResultStatus.apply(task.getStatus())).willReturn(ResultStatus.STARTING);
    given(analysisClient.setStatus(any(), any())).willReturn(Mono.empty());
    listener.handleEvent(event);
    verify(analysisClient).setStatus(task.getId(), ResultStatus.STARTING);
  }

}
