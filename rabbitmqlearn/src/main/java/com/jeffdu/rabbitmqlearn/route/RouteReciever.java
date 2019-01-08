package com.jeffdu.rabbitmqlearn.route;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 名称：<br>
 * 描述：<br>
 *
 * @author JeffDu
 * @version 1.0
 * @since 1.0.0
 */
@Component
public class RouteReciever {
    @RabbitListener(queues = "routeA")
    public void receiver0(String str) {
        System.out.println("receiver0++++++++++:" + str);
    }

    @RabbitListener(queues = "routeB")
    public void receiver1(String str) {
        System.out.println("receiver1++++++++++:" + str);
    }
}
