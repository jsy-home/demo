package com.example.demo.bussiness.mapper;

import com.example.demo.bussiness.entity.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountMapper {
 Account findAccountById(@Param("username") String name,@Param("password") String password);
}
