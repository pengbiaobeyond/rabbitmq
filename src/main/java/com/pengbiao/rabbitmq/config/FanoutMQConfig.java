package com.pengbiao.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FanoutMQConfig {

/**
 * springboot项目中整合队列
 */
    /**
     * 定义交换机
     */
    private String EXCHANGE_FANOUT_NAME = "mayikt_fanout_exchange";


    /**
     * 短信队列
     */
    private String FANOUT_QUEUE_SMS = "mayikt_fanout_sms_queue";
    /**
     * 邮件队列
     */
    private String FANOUT_QUEUE_EMAIL = "mayikt_fanout_email_queue";


    /**
     * 声明的sms队列
     *
     * @return
     */
    @Bean
    public Queue smsFanoutQueue() {
        return new Queue(FANOUT_QUEUE_SMS,true);
    }

    /**
     * 声明的email队列
     *
     * @return
     */
    @Bean
    public Queue emailFanoutQueue() {
        return new Queue(FANOUT_QUEUE_EMAIL,true);
    }



    /**
     * 声明我们的交换机
     *
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(EXCHANGE_FANOUT_NAME,true,true);
    }

    /**
     * 短信队列绑定我们的交换机-
     *
     * @param smsFanoutQueue
     * @param fanoutExchange
     * @return
     */
    @Bean
    public Binding smsBindingFanoutExchange(Queue smsFanoutQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(smsFanoutQueue).to(fanoutExchange);
    }

    /**
     * 邮件队列绑定我们的交换机-
     *
     * @param emailFanoutQueue
     * @param fanoutExchange
     * @return
     */
    @Bean
    public Binding emailBindingFanoutExchange(Queue emailFanoutQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(emailFanoutQueue).to(fanoutExchange);
    }
}
