package com.qwipper.users.application.events;

import com.qwipper.common.messaging.publisher.AbstractDomainPublisher;
import com.qwipper.common.messaging.publisher.EventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserEventPublisher extends AbstractDomainPublisher {
    protected UserEventPublisher(EventPublisher eventPublisher) {
        super(eventPublisher, "users");
    }
}
