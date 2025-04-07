package com.qwipper.common.messaging.publisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQEventPublisher implements EventPublisher {
    private final AmqpTemplate amqpTemplate;
    private final MessageConverter messageConverter;

    public RabbitMQEventPublisher(AmqpTemplate amqpTemplate,
                                  MessageConverter messageConverter) {
        this.amqpTemplate = amqpTemplate;
        this.messageConverter = messageConverter;
    }

    @Override
    public void publish(String exchange, String routingKey, Object event) {
        amqpTemplate.convertAndSend(exchange, routingKey, event, this::enhanceMessage);
    }

    @Override
    public void publish(String queueName, Object event) {
        amqpTemplate.convertAndSend("", queueName, event, this::enhanceMessage);
    }

    private Message enhanceMessage(Message message) {
        MessageProperties properties = message.getMessageProperties();
        properties.setContentType(MessageProperties.CONTENT_TYPE_JSON);
        properties.setDeliveryMode(MessageProperties.DEFAULT_DELIVERY_MODE);

        return message;
    }
}
