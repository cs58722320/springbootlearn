package com.jeffdu.rabbitmqlearn.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
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
}
