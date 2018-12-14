package com.jeffdu.rabbitmqlearn.worker;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 名称：消息消费者B<br>
 * 描述：消息消费者B<br>
 *
 * @author JeffDu
 * @version 1.0
 * @since 1.0.0
 */
@Component
public class MessageConsumerE {
    @RabbitListener(queues = "workQueue")
    public void on(Message message, Channel channel) throws IOException {
        channel.basicQos(1);
        System.out.println("consumerE" + new String(message.getBody()));
    }
}
