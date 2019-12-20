package com.chen.elegant.config.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class DirectRabbitConfig {
    //队列起名
    @Bean
    public Queue testDirectQueue(){
        return new Queue("TestDirectQueue",true);//true 是否持久
    }

    //Direct交换机 起名：TestDirectExchange
    @Bean
    DirectExchange testDirectExchange(){
        return new DirectExchange("TestDirectExchange");
    }

    //将队列与交换机绑定，并设置用于匹配键：TestDirectRouting
    @Bean
    Binding bindingDirect(){
        return BindingBuilder.bind(testDirectQueue()).to(testDirectExchange()).with("TestDirectRouting");
    }

    @Bean
    DirectExchange lonelyDirectExchange() {
        return new DirectExchange("lonelyDirectExchange");
    }
}
