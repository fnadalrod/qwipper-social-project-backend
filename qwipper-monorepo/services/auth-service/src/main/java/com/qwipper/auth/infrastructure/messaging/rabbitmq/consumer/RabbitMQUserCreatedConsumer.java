package com.qwipper.auth.infrastructure.messaging.rabbitmq.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qwipper.auth.application.command.CreateAuthUserCommand;
import com.qwipper.auth.application.command.CreateAuthUserCommandHandler;
import com.qwipper.auth.application.event.CreateAuthUserEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class RabbitMQUserCreatedConsumer {

    private final CreateAuthUserCommandHandler handler;

    public RabbitMQUserCreatedConsumer(CreateAuthUserCommandHandler handler) {
        this.handler = handler;
    }

    @RabbitListener(queues = "#{@authQueue}")
    public void handleUserCreatedEvent(byte[] message) {

        try {
            String jsonMessage = new String(message, StandardCharsets.UTF_8);
            CreateAuthUserEvent event = new ObjectMapper().readValue(jsonMessage, CreateAuthUserEvent.class);

            CreateAuthUserCommand command = new CreateAuthUserCommand(
                    event.payload().id(),
                    event.payload().userName(),
                    event.payload().passwordHash()
            );

            handler.handle(command);
        } catch (Throwable e) {
            throw new RuntimeException("Invalid JSON arrived to queue");
        }
    }
}
