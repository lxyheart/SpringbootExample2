package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lixingyuan on 2018/5/9.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/toLogin")
    public  String toLogin(){
        return "login";
    }

    @Autowired
    private RedisTemplate template;

    @RequestMapping("/setValue")
    @ResponseBody
    public String setValue(){
        if(!template.hasKey("lxy")){
            template.opsForValue().append("lxy", "heart");
            return "使用redis缓存保存数据成功";
        }else{
            template.delete("lxy");
            return "key已存在";
        }
    }

    @RequestMapping("/getValue")
    @ResponseBody
    public String getValue(){

        if(!template.hasKey("lxy")){
            return "key不存在，请先保存数据";
        }else{
            Object shabao = template.opsForValue().get("lxy");//根据key获取缓存中的val
            return "获取到缓存中的数据：shabao="+shabao;
        }
    }

    @RequestMapping(value="/findByPassword",method = RequestMethod.GET)
    @ResponseBody
    public User findByUserName(String password){
        User user = userService.findByPassword(password);
        Object u = template.opsForValue().get("user::pasword_123456");
        System.out.println(u);
        return user;
    }
}
