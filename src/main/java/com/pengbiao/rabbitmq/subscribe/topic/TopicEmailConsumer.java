package com.pengbiao.rabbitmq.subscribe.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "mayikt_topic_email_queue")
public class TopicEmailConsumer {

    /**
     * 监听队列回调的方法
     *
     * @param msg
     */
    @RabbitHandler
    public void process(String msg) {
        System.out.println("邮件消费者消息msg:" + msg);
    }
}
