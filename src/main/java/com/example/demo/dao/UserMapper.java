package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lixingyuan on 2018/5/9.
 */
@Mapper
public interface UserMapper extends JpaRepository<User,String>{
    /**
     * 符合jpa方法的命名规范，无须写出sql语句
     * @param username
     * @return
     */
   /* User findByUsernameAanPassword(String username,String password);*/
    User findByPassword(String password);
}
