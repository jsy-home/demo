package com.example.demo.bussiness.service;

import com.example.demo.base.utils.MsgResult;
import com.example.demo.bussiness.entity.Account;
import com.example.demo.bussiness.entity.User;
import com.example.demo.bussiness.mapper.AccountMapper;
import com.example.demo.bussiness.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public MsgResult checkAccount(Account account) {
        Account accountById = accountMapper.findAccountById(account.getUser().getUsername(),account.getPassword());
        MsgResult msg=new MsgResult();
        if(null!=accountById){
            msg.setCode(1);
            msg.setMessage(accountById.getUser().getUsername()+"登陆成功");
        }else {
            msg.setMessage("用户名密码错误");
            msg.setCode(0);
        }
        return msg;
    }

    @Override
    public MsgResult login(User user) {
        MsgResult msgResult=new MsgResult();
        User userByName = userMapper.getUserByName(user.getUsername());
        if (null == userByName) {
            msgResult.setMessage("登录账号失败");
            return msgResult;
        }else {
            msgResult.setMessage("操作成功"+userByName.getUsername());
        }
        return msgResult;
    }


    @Override
    public MsgResult register(User user) {
        int insert = userMapper.insert(user);
        MsgResult msgResult=new MsgResult();
        if(1==insert){
            msgResult.setCode(1);
            msgResult.setMessage("用户注册成功"+" id:"+user.getId());
        }else{
            msgResult.setCode(0);
            msgResult.setMessage("用户注册失败");
        }
        return msgResult;
    }
}
