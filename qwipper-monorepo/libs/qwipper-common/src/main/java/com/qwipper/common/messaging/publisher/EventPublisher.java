package com.qwipper.common.messaging.publisher;

public interface EventPublisher {
    void publish(String exchange, String routingKey, Object event);
    void publish(String routingKey, Object event);
    }
