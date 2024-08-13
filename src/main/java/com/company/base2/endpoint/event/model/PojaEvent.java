package com.company.base2.endpoint.event.model;

import static com.company.base2.endpoint.event.EventStack.EVENT_STACK_1;

import com.company.base2.PojaGenerated;
import com.company.base2.endpoint.event.EventStack;
import java.io.Serializable;
import java.time.Duration;

@PojaGenerated
@SuppressWarnings("all")
public abstract class PojaEvent implements Serializable {
  public abstract Duration maxConsumerDuration();

  private Duration randomConsumerBackoffBetweenRetries() {
    return Duration.ofSeconds(maxConsumerBackoffBetweenRetries().toSeconds());
  }

  public abstract Duration maxConsumerBackoffBetweenRetries();

  public final Duration randomVisibilityTimeout() {
    var eventHandlerInitMaxDuration = Duration.ofSeconds(90); // note(init-visibility)
    return Duration.ofSeconds(
        eventHandlerInitMaxDuration.toSeconds()
            + maxConsumerDuration().toSeconds()
            + randomConsumerBackoffBetweenRetries().toSeconds());
  }

  public EventStack getEventStack() {
    return EVENT_STACK_1;
  }

  public String getEventSource() {
    if (getEventStack().equals(EVENT_STACK_1)) return "com.company.base2.event1";
    return "com.company.base2.event2";
  }
}