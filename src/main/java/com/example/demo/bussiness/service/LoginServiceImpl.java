package com.example.demo.bussiness.service;

import com.example.demo.base.utils.MsgResult;
import com.example.demo.base.utils.TokenMethod;
import com.example.demo.bussiness.domain.RegisterRequestDTO;
import com.example.demo.bussiness.entity.Account;
import com.example.demo.bussiness.entity.SpringBootPropertiesEntity;
import com.example.demo.bussiness.entity.User;
import com.example.demo.bussiness.mapper.AccountMapper;
import com.example.demo.bussiness.mapper.UserMapper;
import com.example.demo.excepion.DGExcepion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    SpringBootPropertiesEntity springBootPropertiesEntity;

    @Override
    public MsgResult<String> checkAccount(Account account) {
        Account accountById = accountMapper.findAccountById(account.getUser().getUsername(), account.getPassword());
        if (null != accountById) {
            return login(account.getUser());
        } else {
//            return null;
            return MsgResult.fail(0,"用户名密码错误");
        }
    }

    @Override
    public MsgResult<String> login(User user) {
        User userByName = userMapper.getUserByName(user.getUsername());
        if (null==userByName) {
            return MsgResult.fail(0,"用户不存在");
        } else {
            String salt = springBootPropertiesEntity.getSalt();
            // 生成token
            String token = TokenMethod.getToken(String.valueOf(userByName.getId()), salt);
            redisTemplate.opsForValue().set(token,String.valueOf(userByName.getId()));
            //  设置过期时间
            // redisTemplate.expire("token::"+userByName.getId(),20, TimeUnit.MINUTES);
            return MsgResult.success(token);
        }
    }


    /**
     *  注册一般流程，选手机号或者邮箱作为系统唯一标识，以邮箱为例：
     * 用户先填邮箱，然后点发送验证码。后台生成随机验证码并发送给用户邮箱，发送成功后把验证码存在redis中，redis的key唯一，并与用户相关。过期时间自己定
     * （每个用户一天的发送次数，前一次发送的间隔时间也需要控制，不能频繁发送）
     * 注册是填写邮箱，密码，二次确认密码，邮箱验证码
     * 校验邮箱在系统中是为已存在，校验密码和二次确认密码是否相同，校验邮箱验证码是否和redis中保存的一样，校验都通过，插入用户表，用户注册成功
     * （密码加密保存）
     *
     * @param user user
     * @return MsgResult
     */
    @Override
    public Integer register(User user, RegisterRequestDTO registerRequestDTO) {
        User isExistUser = userMapper.selectByMobile(user.getMobile());
        String emailValue = redisTemplate.opsForValue().get("emailKey::" + registerRequestDTO.getDestMailAddress());
        if(StringUtils.isEmpty(emailValue)){
            throw new DGExcepion("验证失效或未发送验证码",10002);
        }else if(!registerRequestDTO.getMa().equals(emailValue)){
            throw new DGExcepion("输入的验证错误",10002);
        }
        if(null!=isExistUser){
            throw new DGExcepion("该手机号已经注册！",10001);
        }
        int insert = userMapper.insert(user);
        if (1 == insert) {
            redisTemplate.delete("emailKey::" + registerRequestDTO.getDestMailAddress());
            return 1;
        } else {
            return 0;
        }
    }
}
