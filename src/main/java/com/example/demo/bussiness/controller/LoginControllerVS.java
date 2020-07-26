package com.example.demo.bussiness.controller;

import com.example.demo.base.utils.MsgResult;
import com.example.demo.bussiness.entity.Account;
import com.example.demo.bussiness.entity.User;
import org.springframework.web.bind.annotation.RequestBody;

public interface LoginControllerVS {
     String userLogin();
     MsgResult login(String password,String username);
     MsgResult register(String username, String mobile);
}
