package com.example.demo.bussiness.controller;

import com.example.demo.base.utils.MsgResult;
import com.example.demo.bussiness.domain.LoginRequestDTO;
import com.example.demo.bussiness.domain.RegisterRequestDTO;
import com.example.demo.bussiness.entity.Account;

/**
 *
 */
public interface LoginControllerVS {
     /**
      *
      * @return
      */
     String userLogin();

     /**
      * @param loginRequestDTO login
      * @return
      */
     MsgResult login(LoginRequestDTO loginRequestDTO);

     /**
      * @param registerRequestDTO register
      * @return
      */
     MsgResult<Account> register(RegisterRequestDTO registerRequestDTO);
}
