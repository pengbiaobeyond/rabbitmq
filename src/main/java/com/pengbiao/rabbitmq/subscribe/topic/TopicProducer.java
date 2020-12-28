package com.pengbiao.rabbitmq.subscribe.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Description : 发布订阅模式，常用的就是topic模式
 * @ Author : pengbiao
 * @ Date : 2020/12/28 14:09
 * @ Version : 1.0
 */
@RestController
public class TopicProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;
    /**
     * 定义交换机
     */
    private String EXCHANGE_SPRINGBOOT_NAME = "mayikt_topic_exchange";

    @RequestMapping("/sendSmsTopicMsg")
    public String sendSmsTopicMsg(String message) {
        // 投递消息 客户端不会立马知道消费是否被消费，但是能够确认知道我们是否投递到消息中间件
        amqpTemplate.convertAndSend(EXCHANGE_SPRINGBOOT_NAME,"sms", message);
//        amqpTemplate.convertAndSend(EXCHANGE_SPRINGBOOT_NAME,"email", message);
        /*  根据消息全局id主动查询
         */
        return "success";
    }

    @RequestMapping("/sendEmailTopicMsg")
    public String sendEmailTopicMsg(String message) {
        // 投递消息 客户端不会立马知道消费是否被消费，但是能够确认知道我们是否投递到消息中间件
        amqpTemplate.convertAndSend(EXCHANGE_SPRINGBOOT_NAME,"email.a", message);
//        amqpTemplate.convertAndSend(EXCHANGE_SPRINGBOOT_NAME,"email", message);
        /*  根据消息全局id主动查询
         */
        return "success";
    }


}
