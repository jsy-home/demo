package com.example.demo.user.controller;

import com.example.demo.user.dao.UserMapper;
import com.example.demo.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by jackjiang  2020.7.8
 *
 * @ RestController=>@ Controller + @ ResponseBody 返回json
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/hello")
    public User hello() {

        return userMapper.selectByPrimaryKey(1L);
    }

}
