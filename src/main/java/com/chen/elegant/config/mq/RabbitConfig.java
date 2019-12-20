package com.chen.elegant.config.mq;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class RabbitConfig {

    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory){

        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        //设置开启Mandatory,才能触发回调函数,无论消息推送结果怎么样都强制调用回调函数
        rabbitTemplate.setMandatory(true);

        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
                    if (ack) {
//                         log.info("消息发送到exchange成功,id: {}", correlationData.getId());
                    } else {
                        log.info("消息发送到exchange失败,原因: {}", cause);
                    }
                });

        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
                    String correlationId = message.getMessageProperties().getCorrelationId();
                    log.info("消息：{} 发送失败, 应答码：{} 原因：{} 交换机: {}  路由键: {}", correlationId, replyCode, replyText, exchange, routingKey);
                });
        return rabbitTemplate;
    }
}
