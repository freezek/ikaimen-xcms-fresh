package com.ikaimen.core.rabbitmq;

import com.ikaimen.core.entity.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/5/12.
 */
@Component
public class HelloReceive {
    @RabbitListener(queues="workQueue")    //监听器监听指定的Queue
    public void processC(String str) {
        System.out.println("消息通知:"+str);
        System.out.println("投注地点：云南省昆明市国家级经济开发区！");
    }

    @RabbitListener(queues = "queue")
    public void test(User user){
        System.out.println("生产者对象："+user.toString());
    }
}
