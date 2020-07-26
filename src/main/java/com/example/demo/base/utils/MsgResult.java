package com.example.demo.base.utils;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;



@Data
@Component
@NoArgsConstructor
public  class MsgResult {
    private Object data;
    private Integer code;
    private String message;
}
