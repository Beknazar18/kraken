package com.kraken.runtime.client;

import com.kraken.runtime.entity.Container;
import com.kraken.runtime.entity.ContainerStatus;
import com.kraken.runtime.entity.Task;
import reactor.core.publisher.Mono;

public interface RuntimeClient {

  Mono<Task> waitForStatus(String taskId, ContainerStatus status);

  Mono<Container> setStatus(String containerId, ContainerStatus status);

}