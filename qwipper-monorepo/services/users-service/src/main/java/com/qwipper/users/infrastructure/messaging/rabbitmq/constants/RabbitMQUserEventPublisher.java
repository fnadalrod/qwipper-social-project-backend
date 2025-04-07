package com.qwipper.users.infrastructure.messaging.rabbitmq.constants;

import com.qwipper.common.messaging.publisher.AbstractDomainPublisher;
import com.qwipper.users.domain.model.events.UserCreatedEvent;
import com.qwipper.users.domain.model.ports.output.UserEventOutputPort;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RabbitMQUserEventPublisher implements UserEventOutputPort {
    private final AbstractDomainPublisher rabbitPublisher;

    public RabbitMQUserEventPublisher(AbstractDomainPublisher rabbitPublisher) {
        this.rabbitPublisher = rabbitPublisher;
    }

    @Override
    public void publish(UserCreatedEvent event) {
        rabbitPublisher.publish(
                RabbitMQQueues.AUTH_CREATED_USER,
                Map.of(
                        "id", event.getUserId().toString(),
                        "userName", event.getUserName().toString(),
                        "email", event.getEmail().toString(),
                        "passwordHash", event.getPasswordHash()
                )
        );
    }
}
