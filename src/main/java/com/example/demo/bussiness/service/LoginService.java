package com.example.demo.bussiness.service;

import com.example.demo.base.utils.MsgResult;
import com.example.demo.bussiness.entity.Account;
import com.example.demo.bussiness.entity.User;
import org.springframework.stereotype.Service;


public interface LoginService {


     MsgResult login(User user);
     MsgResult register(User user);
     MsgResult checkAccount(Account account);
}
