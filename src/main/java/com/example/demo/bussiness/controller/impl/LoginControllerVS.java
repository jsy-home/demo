package com.example.demo.bussiness.controller.impl;

import com.example.demo.base.utils.MsgResult;
import com.example.demo.bussiness.entity.User;
import org.springframework.web.bind.annotation.RequestBody;

public interface LoginControllerVS {
     String userLogin();
     MsgResult login(User user);
     MsgResult register(String username, String mobile);
}
