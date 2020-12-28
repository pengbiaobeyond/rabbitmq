package com.pengbiao.rabbitmq.ptp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PtpTopicProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 短信队列
     */
    private String POINT_QUEUE_SMS = "mayikt_ptp_sms_queue";

    @RequestMapping("/sendPtpMsg")
    public String sendMsg(String message) {
        // 投递消息 客户端不会立马知道消费是否被消费，但是能够确认知道我们是否投递到消息中间件
        amqpTemplate.convertAndSend(POINT_QUEUE_SMS, message);
        /*  根据消息全局id主动查询
         */
        return "success";
    }
}
