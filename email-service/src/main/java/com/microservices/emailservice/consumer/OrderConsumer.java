package com.microservices.emailservice.consumer;

import com.microservices.emailservice.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @RabbitListener(queues = "${rabbitmq.queue.name.email}")
    public void consume(OrderEvent orderEvent) {
        LOGGER.info(String.format("Order event received in email service => %s", orderEvent.toString()));
        System.out.println("Email sent");
        // send email to the customer
    }
}
