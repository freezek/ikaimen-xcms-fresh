package com.ikaimen.test;

import com.ikaimen.AikaimenSpringBootXcmsApplication;
import com.ikaimen.rabbitmq.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/5/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AikaimenSpringBootXcmsApplication.class)
public class MyTest {

    @Autowired
    private HelloSender helloSender;

    @Test
    public void testRabbit() {
        helloSender.send();
    }

}
