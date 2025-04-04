package com.qwipper.common.messaging.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQExchangeConfig {
    @Bean
    public TopicExchange domainEventsExchange() {
        return new TopicExchange("domain.events");
    }

    @Bean
    public FanoutExchange deadLetterExchange() {
        return new FanoutExchange("dead.letter.exchange");
    }
}
