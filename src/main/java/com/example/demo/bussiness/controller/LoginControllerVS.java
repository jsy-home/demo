package com.example.demo.bussiness.controller;

import com.example.demo.base.utils.MsgResult;
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
      *
      * @param password
      * @param username
      * @return
      */
     MsgResult login(String password,String username);

     /**
      *
      * @param username
      * @param mobile
      * @return
      */
     MsgResult<Account> register(String username, String mobile);
}
