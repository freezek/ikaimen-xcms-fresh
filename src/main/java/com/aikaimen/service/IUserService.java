package com.aikaimen.service;

import com.aikaimen.entity.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/5.
 */
public interface IUserService {

    int addUser(User user);

    List<User> findAll();

    User findById(int id);



}
