package com.jeffdu.rabbitmqlearn.worker;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 名称：消息生产者<br>
 * 描述：消息生产者<br>
 *
 * @author JeffDu
 * @version 1.0
 * @since 1.0.0
 */
@Component
public class MessageProvider {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(){
        for(int i = 0; i < 100000; i++){
            String context = "providerMessage";
            context = context.concat((i + 1) + "");
            CorrelationData correlationData = new CorrelationData(context);
//            rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
            rabbitTemplate.setEncoding("UTF-8");
            this.rabbitTemplate.convertAndSend("workQueue", context);
        }
    }
}
