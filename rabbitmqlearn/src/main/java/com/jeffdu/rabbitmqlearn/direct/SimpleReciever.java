package com.jeffdu.rabbitmqlearn.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 名称：简单队列接收者<br>
 * 描述：简单队列接收者<br>
 *
 * @author JeffDu
 * @version 1.0
 * @since 1.0.0
 */
@Component
@RabbitListener(queues = "hello")
public class SimpleReciever {

    @RabbitHandler
    public void recieve(String context){
        System.out.println("reciever:" + context);
    }


}
