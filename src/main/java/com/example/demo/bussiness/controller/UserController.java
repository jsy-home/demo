package com.example.demo.bussiness.controller;

import com.example.demo.bussiness.entity.User;
import com.example.demo.bussiness.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
