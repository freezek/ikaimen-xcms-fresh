package com.ikaimen.properties;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/5/12.
 */
@Configuration
public class SenderConf  {
    @Bean
    public Queue queue() {
        return new Queue("queue");
    }

    @Bean
    public Queue queue2() {
        return new Queue("workQueue");
    }
}
