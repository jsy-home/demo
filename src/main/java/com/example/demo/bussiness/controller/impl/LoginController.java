package com.example.demo.bussiness.controller.impl;


import com.example.demo.base.utils.MsgResult;
import com.example.demo.bussiness.controller.LoginControllerVS;
import com.example.demo.bussiness.entity.Account;
import com.example.demo.bussiness.entity.User;
import com.example.demo.bussiness.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController implements LoginControllerVS {

    @Autowired
    private LoginService loginService;


    @RequestMapping(value = "/toLogin")
    public String userLogin(){

        return "login";
    }


    @ResponseBody
    @RequestMapping("/login")
    public MsgResult login(String password,String username){
          Account acc=new Account();
          User user=new User();
          user.setUsername(username);
          acc.setPassword(password);
          acc.setUser(user);
        return loginService.checkAccount(acc);
    }

    @ResponseBody
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public MsgResult register( String username, String mobile){
        User user=new User();
        user.setUsername(username);
        user.setMobile(mobile);
        return loginService.register(user);
    }
}
