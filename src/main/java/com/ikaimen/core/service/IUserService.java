package com.ikaimen.core.service;

import com.ikaimen.core.entity.model.User;

import java.util.List;

/**
 * Created by Administrator on 2017/5/5.
 */
public interface IUserService {

    int addUser(User user);

    List<User> findAll();

    User findById(int id);



}
