package com.example.demo.base.utils;
import lombok.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
// todo 代码规范，空行太多，idea下个插件 Alibaba Java Coding Guidelines

@Getter
@Component
@ToString
@NoArgsConstructor
public  class  MsgResult<T> {
    private T data ;
    private Integer code;
    private String message;

    private MsgResult(Builder<T> builder){
        this.message=builder.message;
        this.code=builder.code;
        this.data=builder.data;
    }
    private static <T> Builder<T> builder(){
        return new Builder<>();
    }

    public static <T> MsgResult<T> success(T data){
        Builder<T> builder = builder();
        return builder.setCode(1).setMessage("Success").setData(data).build();
    }

    public static <T> MsgResult<T> fail(Integer code,String message){
        Builder<T> builder = builder();
        return builder.setCode(code).setMessage(message).build();
    }

    public static class Builder<T>{
        private T data ;
        private Integer code;
        private String message;
        public Builder(){}
        public Builder<T> setData(T data){
            this.data=data;
            return this;
        }
        public Builder<T> setCode(Integer code){
            this.code=code;
            return this;
        }
        public Builder<T> setMessage(String message){
            this.message=message;
            return this;
        }
        public MsgResult<T> build(){
            return new MsgResult<>(this);
        }



    }



}
