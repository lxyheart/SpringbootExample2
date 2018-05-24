package com.example.demo.service.impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lixingyuan on 2018/5/14.
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserMapper userMapper;
   /* @Override
    public User findByUsernameAanPassword(String username, String password) {
        return userMapper.findByUsernameAanPassword(username,password);
    }*/

    @Override
    public User findByPassword(String password) {
        User user = userMapper.findByPassword(password);
        System.out.println("取数据");
        return user;
    }
}
