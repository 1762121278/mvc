package com.dfgx.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author Today
 */
@Component
@Slf4j
public class KafkaReceiver {

    @KafkaListener(topics = "topic3")
    //@Payload注解自动转化为对象
    public void listen(@Payload String message){
        log.info("接收到消息message={}",message);
    }
}