package com.example.demo.bussiness.service;

import com.example.demo.base.utils.MsgResult;
import com.example.demo.bussiness.domain.RegisterRequestDTO;
import com.example.demo.bussiness.entity.Account;
import com.example.demo.bussiness.entity.User;
import org.springframework.stereotype.Service;

/**
 * Demo class
 *
 * @author keriezhang
 * @date 2020/7/27
 */
public interface LoginService {


     MsgResult login(User user);
     Integer register(User user, RegisterRequestDTO registerRequestDTO);
     MsgResult<String> checkAccount(Account account);
}
