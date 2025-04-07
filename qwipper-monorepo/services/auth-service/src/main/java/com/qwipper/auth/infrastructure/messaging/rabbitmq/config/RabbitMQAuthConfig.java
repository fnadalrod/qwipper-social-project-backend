package com.qwipper.auth.infrastructure.messaging.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQAuthConfig {

    @Bean
    public Queue authQueue() {
        return new Queue("auth.users.user-created.queue", true);
    }
}
