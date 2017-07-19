package com.ikaimen.service;

import com.ikaimen.entity.model.User;

import java.util.List;

/**
 * Created by Administrator on 2017/5/5.
 */
public interface IUserService {

    int addUser(User user);

    List<User> findAll();

    User findById(int id);



}
