package com.dfgx.user.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class KafkaMessage {
    /**
     * id
     */
    private Long id;
    /**
     * 消息
     */
    private String msg;
    /**
     * 时间戳
     */
    private Date sendTime;

}
