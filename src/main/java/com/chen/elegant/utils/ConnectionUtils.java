package com.chen.elegant.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectionUtils {

    /**
     * 获取MQ的连接
     * @return
     */
    public static Connection getConnection() throws Exception {
        //定义连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置服务地址
        factory.setHost("127.0.0.1");
        //AMQP 5672
        factory.setPort(5672);
        //vhost
        factory.setVirtualHost("/vhosts_mmr");
        //用户名
        factory.setUsername("admin");
        //密码
        factory.setPassword("123456");

        return factory.newConnection();
    }
}

