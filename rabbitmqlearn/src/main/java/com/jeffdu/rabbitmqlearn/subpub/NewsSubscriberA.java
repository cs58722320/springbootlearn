package com.jeffdu.rabbitmqlearn.subpub;

import com.jeffdu.rabbitmqlearn.MessageSubject;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 名称：新闻订阅者A<br>
 * 描述：新闻订阅者A<br>
 *
 * @author JeffDu
 * @version 1.0
 * @since 1.0.0
 */
@Component
@RabbitListener(queues = "subscriberA")
public class NewsSubscriberA {

    @RabbitHandler
    public void recievedMessage(MessageSubject<String> messageSubject) throws IOException {
        System.out.println("consumerA" + messageSubject.toString());
    }

}
