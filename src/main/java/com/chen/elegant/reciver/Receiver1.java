package com.chen.elegant.reciver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
//@RabbitListener(queues = "topic.man")
public class Receiver1 {

    @RabbitHandler
    public void receiver(Map msg){
        System.out.println("TopicManReceiver消费者收到消息:"+msg.toString());
    }
}
