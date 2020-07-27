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
    // todo 加override 注解
    public String userLogin(){

        return "login";
    }


    @ResponseBody
    // todo RequestMapping 指定请求方式
    @RequestMapping("/login")
    // todo 登录请求参数放在body中
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
    // todo POST 最好搭配 requestbody一起使用，不要拼在url后面
    public MsgResult register( String username, String mobile){
        User user=new User();
        user.setUsername(username);
        user.setMobile(mobile);
        return loginService.register(user);
    }
}
