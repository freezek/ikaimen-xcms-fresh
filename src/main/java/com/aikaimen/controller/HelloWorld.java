package com.aikaimen.controller;

import com.aikaimen.entity.model.User;
import com.aikaimen.properties.GirlPropertis;
import com.aikaimen.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/5.
 */
@RestController
public class HelloWorld {

    @Autowired
    private GirlPropertis girlPropertis;

    @Autowired
    private IUserService userService;

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello(){

        User user = new User();
        user.setName("王五");
        user.setAge(18);

        userService.addUser(user);


        return userService.findById(10).toString();
    }
}
