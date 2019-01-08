package com.jeffdu.rabbitmqlearn.route;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 名称：<br>
 * 描述：<br>
 *
 * @author JeffDu
 * @version 1.0
 * @since 1.0.0
 */
@RestController
public class RouteSender {

    @Autowired
    private DirectExchange directExchange;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    private String[] keys = {"orange", "black", "white"};


    @RequestMapping("/routeSend")
    public void send() {
        String message = "哈哈哈";
        for(int i = 0; i < 5; i++) {
            System.out.println("send++++++++++:".concat(message));
            rabbitTemplate.convertAndSend(directExchange.getName(), keys[1], message);
        }
    }
}
