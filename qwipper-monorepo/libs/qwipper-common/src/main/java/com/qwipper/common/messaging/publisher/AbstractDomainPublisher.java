package com.qwipper.common.messaging.publisher;

import java.time.Instant;
import java.util.Map;

public abstract class AbstractDomainPublisher {
    protected final EventPublisher eventPublisher;
    protected final String contextName;

    public AbstractDomainPublisher(EventPublisher eventPublisher, String contextName) {
        this.eventPublisher = eventPublisher;
        this.contextName = contextName;
    }

    public void publish(String exchange, String queueName, Object payload) {
        Map<String, Object> message = Map.of(
                "context", contextName,
                "type", queueName,
                "payload", payload,
                "timestamp", Instant.now().toString()
        );

        eventPublisher.publish(exchange, queueName, message);
    }

    public void publish(String queueName, Object payload) {
        Map<String, Object> message = Map.of(
                "context", contextName,
                "payload", payload,
                "timestamp", Instant.now().toString()
        );

        eventPublisher.publish(queueName, message);
    }
}
