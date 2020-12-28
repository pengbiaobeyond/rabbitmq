package com.pengbiao.rabbitmq.ptp;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
/**
 * @ Description :  点对点
 * @ Author : pengbiao
 * @ Date : 2020/12/28 14:08
 * @ Version : 1.0
 */
@Component
@RabbitListener(queues = "mayikt_ptp_sms_queue")
public class PtpSmsConsumer {

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
