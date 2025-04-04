package com.qwipper.common.messaging.publisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQEventPublisher implements EventPublisher {
    private final AmqpTemplate amqpTemplate;
    private final MessageConverter messageConverter;
    private final String defaultExchange;

    public RabbitMQEventPublisher(AmqpTemplate amqpTemplate,
                                  MessageConverter messageConverter,
                                  @Value("${spring.rabbitmq.template.exchange:}") String defaultExchange) {
        this.amqpTemplate = amqpTemplate;
        this.messageConverter = messageConverter;
        this.defaultExchange = defaultExchange;
    }

    @Override
    public void publish(String exchange, String routingKey, Object event) {
        amqpTemplate.convertAndSend(exchange, routingKey, event, this::enhanceMessage);
    }

    @Override
    public void publish(String routingKey, Object event) {
        if (defaultExchange.isEmpty()) {
            throw new IllegalStateException("Default exchange not configured");
        }

        publish(defaultExchange, routingKey, event);
    }

    private Message enhanceMessage(Message message) {
        MessageProperties properties = message.getMessageProperties();
        properties.setContentType(MessageProperties.CONTENT_TYPE_JSON);
        properties.setDeliveryMode(MessageProperties.DEFAULT_DELIVERY_MODE);

        return message;
    }
}
