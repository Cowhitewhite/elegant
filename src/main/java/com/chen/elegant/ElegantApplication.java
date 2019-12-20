package com.chen.elegant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling//启动定时任务
@SpringBootApplication
public class ElegantApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElegantApplication.class, args);
    }

}
