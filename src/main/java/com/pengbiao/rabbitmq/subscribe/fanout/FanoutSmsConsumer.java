package com.pengbiao.rabbitmq.subscribe.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "mayikt_fanout_sms_queue")
public class FanoutSmsConsumer {

    /**
     * 监听队列回调的方法
     *
     * @param msg
     */
    @RabbitHandler
    public void process(String msg) {
        System.out.println("短信消费者消息msg:" + msg);
    }
}
