package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by lixingyuan on 2018/5/9.
 */
public interface UserService {
   /* public User findByUsernameAanPassword(String username,String password);*/
   @Cacheable(value="user", key="'pasword_'+#password")
   User findByPassword(String password);
}
