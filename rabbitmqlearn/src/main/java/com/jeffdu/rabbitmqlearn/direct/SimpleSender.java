package com.jeffdu.rabbitmqlearn.direct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 名称：简单队列发送者<br>
 * 描述：简单队列发送者<br>
 *
 * @author JeffDu
 * @version 1.0
 * @since 1.0.0
 */
@Component
public class SimpleSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String context = "hello" + new Date();
        this.rabbitTemplate.convertAndSend("hello", context);
    }
}
