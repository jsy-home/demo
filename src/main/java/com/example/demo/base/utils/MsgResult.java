package com.example.demo.base.utils;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


// todo 代码规范，空行太多，idea下个插件 Alibaba Java Coding Guidelines

// todo Data注解包含了 NoArgsConstructor
@Data
@Component
@NoArgsConstructor
public  class MsgResult {
    // todo 封装太简单了，最好把Object改成泛型，用builder模式重新封装
    private Object data;
    private Integer code;
    private String message;
}
