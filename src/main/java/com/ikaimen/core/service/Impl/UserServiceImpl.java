package com.ikaimen.core.service.Impl;

import com.ikaimen.core.entity.model.User;
import com.ikaimen.core.mapper.UserMapper;
import com.ikaimen.core.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/5.
 */
@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;


    @Override
    public int addUser(User user) {

        int i = userMapper.insert(user.getName(),user.getAge());

        return i;
    }

    @Override
    public List<User> findAll() {

        return userMapper.selectAll();
    }

    @Override
    public User findById(int id) {
        return userMapper.selectById(id);
    }
}
