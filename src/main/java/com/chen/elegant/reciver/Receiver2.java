package com.chen.elegant.reciver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
//@RabbitListener(queues = "topic.woman")
public class Receiver2 {

    @RabbitHandler
    public void receiver(Map msg){
        System.out.println("TopicTotalReceiver消费者收到消息:"+msg.toString());
    }
}
