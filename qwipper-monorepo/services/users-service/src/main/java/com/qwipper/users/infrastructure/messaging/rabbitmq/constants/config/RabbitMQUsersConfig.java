package com.qwipper.users.infrastructure.messaging.rabbitmq.constants.config;

import com.qwipper.common.messaging.config.RabbitMQBaseConfig;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RabbitMQUsersConfig extends RabbitMQBaseConfig {
    @Bean
    @Primary
    @Override
    public MessageConverter jsonMessageConverter() {
        return super.jsonMessageConverter();
    }
}
