package com.brandon.listner;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderMailingListener {

    @RabbitListener(queues = "CREATE_MAIL_QUEUE")
    public void receiveOrderMailing(final Message message) {
        System.out.println(message.getBody());
        System.out.println(message);

    }
}
