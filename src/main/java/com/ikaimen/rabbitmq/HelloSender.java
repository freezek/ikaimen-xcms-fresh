package com.ikaimen.rabbitmq;

import com.ikaimen.entity.model.User;
import com.xiaoleilu.hutool.date.DateUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/12.
 */
@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate template;

    public void send() {

        User user = new User();
        user.setAge(18);
        user.setName("李四");

        for(int i=0;i<=10;i++){
            template.convertAndSend("workQueue","--张三--投注：   "+i+"元。。。。。。"+"  时间:"+ DateUtil.format(new Date(),new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss.SSS")));

            user.setId(i);
            template.convertAndSend("queue",user);
        }

    }
}
