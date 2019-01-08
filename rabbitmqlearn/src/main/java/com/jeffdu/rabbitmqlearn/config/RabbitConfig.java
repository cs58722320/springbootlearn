package com.jeffdu.rabbitmqlearn.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 名称：rabbit配置<br>
 * 描述：rabbit配置<br>
 *
 * @author JeffDu
 * @version 1.0
 * @since 1.0.0
 */
@Configuration
public class RabbitConfig {
    /**
     * 简单队列
     * @return
     */
    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }

    /**
     * Worker队列
     * @return
     */
    @Bean
    public Queue workQueue() {
        return new Queue("workQueue");
    }

    /**
     * 广播交换机
     * @return
     */
    @Bean
    public FanoutExchange exchange(){
        return new FanoutExchange("fanoutExchange");
    }

    /**
     * 直连交换机
     */
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange");
    }

    /**
     * 订阅者A队列
     */
    @Bean
    public Queue queueA(){
        return new Queue("subscriberA", true);
    }

    /**
     * 订阅者B队列
     */
//    @Bean
//    public Queue queueB(){
//        return new Queue("subscriberA", true);
//    }

    /**
     * RoutingA队列
     */
    @Bean
    public Queue routingQueueA(){
        return new Queue("routeA");
    }

    /**
     * RoutingB队列
     */
    @Bean
    public Queue routingQueueB(){
        return new Queue("routeB");
    }


    /**
     * 绑定A
     * @return
     */
    @Bean
    public Binding bindingA(){
        return BindingBuilder.bind(queueA()).to(exchange());
    }

    /**
     * 绑定B
     * @return
     */
//    @Bean
//    public Binding bindingB(){
//        return BindingBuilder.bind(queueB()).to(exchange());
//    }

    /**
     * 绑定路由A
     */
    @Bean
    public Binding bingdingRouteA(){
        return BindingBuilder.bind(routingQueueA()).to(directExchange()).with("black");
    }
    @Bean
    public Binding bingdingRouteA_2(){
        return BindingBuilder.bind(routingQueueB()).to(directExchange()).with("black");
    }


    /**
     * 绑定路由B
     */
    @Bean
    public Binding bingdingRouteB(){
        return BindingBuilder.bind(routingQueueB()).to(directExchange()).with("white");
    }

}
