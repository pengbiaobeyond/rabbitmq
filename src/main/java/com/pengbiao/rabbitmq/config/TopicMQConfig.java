package com.pengbiao.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TopicMQConfig {

/**
 * springboot项目中整合队列
 */
    /**
     * 定义交换机
     */
    private String EXCHANGE_SPRINGBOOT_NAME = "mayikt_topic_exchange";


    /**
     * 短信队列
     */
    private String TOPIC_QUEUE_SMS = "mayikt_topic_sms_queue";
    /**
     * 邮件队列
     */
    private String TOPIC_QUEUE_EMAIL = "mayikt_topic_email_queue";

    private String POINT_QUEUE_SMS = "mayikt_ptp_sms_queue";


    /**
     * 声明的sms队列
     *
     * @return
     */
    @Bean
    public Queue smsQueue() {
        return new Queue(TOPIC_QUEUE_SMS);
    }

    /**
     * 声明的email队列
     *
     * @return
     */
    @Bean
    public Queue emailQueue() {
        return new Queue(TOPIC_QUEUE_EMAIL,true);
    }

    @Bean
    public Queue ptpQueue() {
        return new Queue(POINT_QUEUE_SMS,true);
    }


    /**
     * 声明我们的交换机
     *
     * @return
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(EXCHANGE_SPRINGBOOT_NAME,true,true);
    }

    /**
     * 短信队列绑定我们的交换机-
     *
     * @param smsQueue
     * @param topicExchange
     * @return
     */
    @Bean
    public Binding smsBindingExchange(Queue smsQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(smsQueue).to(topicExchange).with("sms.#");
    }

    /**
     * 邮件队列绑定我们的交换机-
     *
     * @param emailQueue
     * @param topicExchange
     * @return
     */
    @Bean
    public Binding emailBindingExchange(Queue emailQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(emailQueue).to(topicExchange).with("email.*");
    }
}
