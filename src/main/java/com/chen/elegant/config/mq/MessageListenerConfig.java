package com.chen.elegant.config.mq;

import com.chen.elegant.reciver.DirectReceiver;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class MessageListenerConfig {

    @Autowired
    CachingConnectionFactory cachingConnectionFactory;

    @Autowired
    DirectReceiver directReceiver;

    @Autowired
    DirectRabbitConfig directRabbitConfig;

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer(){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(cachingConnectionFactory);
        container.setConcurrentConsumers(1);
        container.setMaxConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); // RabbitMQ默认是自动确认，这里改为手动确认消息
        container.setQueues(directRabbitConfig.testDirectQueue());
        container.setMessageListener(directReceiver);
        return container;
    }
}
