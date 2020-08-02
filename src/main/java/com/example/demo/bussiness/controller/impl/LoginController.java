package com.example.demo.bussiness.controller.impl;


//import com.example.demo.base.utils.MailUtils;
import com.example.demo.base.utils.MailUtils;
import com.example.demo.base.utils.MsgResult;
import com.example.demo.bussiness.controller.LoginControllerVS;
import com.example.demo.bussiness.domain.LoginRequestDTO;
import com.example.demo.bussiness.domain.RegisterRequestDTO;
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
    @Autowired
    MailUtils mailUtils;


    @RequestMapping(value = "/toLogin")
    @Override
    public String userLogin() {
        return "login";
    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test() {
        return "test";
    }


    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @Override
    public MsgResult login(@RequestBody LoginRequestDTO loginRequestDTO) {
        Account acc = new Account();
        User user = new User();
        user.setUsername(loginRequestDTO.getUsername());
        acc.setPassword(loginRequestDTO.getPassword());
        acc.setUser(user);
        MsgResult<String> userMsgResult = loginService.checkAccount(acc);
        return userMsgResult;
    }

    @ResponseBody
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @Override
    public MsgResult register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        User user = new User();
        user.setUsername(registerRequestDTO.getUsername());
        user.setMobile(registerRequestDTO.getMobile());
        int result = loginService.register(user,registerRequestDTO);
        if (result == 1) {
            return MsgResult.success(user);
        }
        return MsgResult.fail(0, "用户注册失败");
    }

    @GetMapping(value = "/mailService")
    @ResponseBody
    public MsgResult getMail(@RequestParam String destMailAddress){
     // 校验邮箱格式
     //  发送邮件
        mailUtils.sendMimeMail(destMailAddress);
        return MsgResult.success("邮件发送成功");
    }
}
