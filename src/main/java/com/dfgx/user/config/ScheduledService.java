package com.dfgx.user.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ScheduledService {
//定时器
    @Scheduled(cron = "0 0 0 * * MON ")
    public void main(){
        System.out.println("这是个定时器");
        log.info("这是个定时器");
    }


    @Scheduled(cron = "2 35 18 * * ? ")
    public void main1(){
        System.out.println("这是个定时器");
        log.info("这是个定时器");
    }

}
