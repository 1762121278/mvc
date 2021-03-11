package com.dfgx.user.controller;

import com.alibaba.fastjson.JSON;
import com.dfgx.user.entity.KafkaMessage;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@Api("kafka应用消息发送")
@Slf4j
public class KafkaController {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    private Gson gson = new Gson();

    //发送消息的方法
    @ApiOperation("fafka发送消息")
    @GetMapping("/sendMsg")
    public int send(){
        String msg = "接收消息";
        System.out.println(msg);
        /*KafkaMessage message = new KafkaMessage();
        message.setId(System.currentTimeMillis());
        message.setMsg(msg);
        message.setSendTime(new Date());
        log.info("发送消息 message = {}", gson.toJson(message));
        kafkaTemplate.send("topic3",gson.toJson(message));*/
        System.out.println("dcfffwf");
        return 111;
    }
}
