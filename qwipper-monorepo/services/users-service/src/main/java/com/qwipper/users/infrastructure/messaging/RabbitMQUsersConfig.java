package com.qwipper.users.infrastructure.messaging;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(com.qwipper.common.messaging.config.RabbitMQExchangeConfig.class)
public class RabbitMQUsersConfig {

    @Bean
    public Queue usersQueue() {
        return QueueBuilder.durable("users.events.queue")
                .withArgument("x-dead-letter-exchange", "dead.letter.exchange")
                .build();
    }

    @Bean
    public Binding usersBinding(TopicExchange domainEventsExchange) {
        return BindingBuilder.bind(usersQueue())
                .to(domainEventsExchange)
                .with("user.*");
    }
}
