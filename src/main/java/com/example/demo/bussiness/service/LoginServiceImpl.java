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


    /**
     * todo 注册一般流程，选手机号或者邮箱作为系统唯一标识，以邮箱为例：
     *  用户先填邮箱，然后点发送验证码。后台生成随机验证码并发送给用户邮箱，发送成功后把验证码存在redis中，redis的key唯一，并与用户相关。过期时间自己定
     *  （每个用户一天的发送次数，前一次发送的间隔时间也需要控制，不能频繁发送）
     *  注册是填写邮箱，密码，二次确认密码，邮箱验证码
     *  校验邮箱在系统中是为已存在，校验密码和二次确认密码是否相同，校验邮箱验证码是否和redis中保存的一样，校验都通过，插入用户表，用户注册成功
     *  （密码加密保存）
     * @param user
     * @return
     */
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
