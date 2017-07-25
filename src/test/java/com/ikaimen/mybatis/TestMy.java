package com.ikaimen.mybatis;

import com.ikaimen.AikaimenSpringBootXcmsApplication;
import com.ikaimen.core.entity.model.User;
import com.ikaimen.core.service.IUserService;
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
public class TestMy {

    @Autowired
    private IUserService userService ;

    @Test
    public  void  testMybatis(){

        User user = new User();
        user.setAge(18);
        user.setName("李四");
        userService.addUser(user);

    }

}
