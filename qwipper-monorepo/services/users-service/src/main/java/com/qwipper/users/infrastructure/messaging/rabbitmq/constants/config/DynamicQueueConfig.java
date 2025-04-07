package com.qwipper.users.infrastructure.messaging.rabbitmq.constants.config;

import com.qwipper.users.infrastructure.messaging.rabbitmq.constants.RabbitMQQueues;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Field;

@Configuration
public class DynamicQueueConfig {
    @Bean
    public ApplicationRunner declareQueuesDynamically(AmqpAdmin amqpAdmin) {
        return args -> {
            DirectExchange exchange = new DirectExchange("direct.exchange", true, false);
            amqpAdmin.declareExchange(exchange);

            for (Field field : RabbitMQQueues.class.getDeclaredFields()) {
                if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                    field.setAccessible(true);
                    String queueName = (String) field.get(null);

                    Queue queue = QueueBuilder.durable(queueName)
                            .withArgument("x-dead-letter-exchange", "dead.letter.exchange")
                            .withArgument("x-dead-letter-routing-key", queueName + ".DLQ")
                            .build();

                    try {
                        amqpAdmin.declareQueue(queue);
                    }  catch (AmqpException e) {

                    }

                    Binding binding = BindingBuilder
                            .bind(queue)
                            .to(exchange)
                            .with(queueName);

                    amqpAdmin.declareBinding(binding);
                }
            }
        };
    }
}
