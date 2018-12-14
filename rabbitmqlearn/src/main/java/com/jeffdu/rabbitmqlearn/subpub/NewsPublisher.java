package com.jeffdu.rabbitmqlearn.subpub;

import com.jeffdu.rabbitmqlearn.MessageSubject;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 名称：发布者实体<br>
 * 描述：发布者实体<br>
 *
 * @author JeffDu
 * @version 1.0
 * @since 1.0.0
 */
@Component
public class NewsPublisher {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    FanoutExchange fanoutExchange;

    AtomicInteger times = new AtomicInteger();

    {
        times.set(0);
    }

    public void send() {
        MessageSubject<String> message = new MessageSubject();
        message.setMessageId("001");
        message.setMessageType("news");
        for(int i = 0; i < 1000; i++){
            message.setContent("message" + times.addAndGet(1));
            rabbitTemplate.convertAndSend(fanoutExchange.getName(), null, message);
            System.out.println(" [x] Sent '" + message + "'");
        }
    }

}
