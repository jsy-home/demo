package com.example.demo.base.utils;
import lombok.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
// todo 代码规范，空行太多，idea下个插件 Alibaba Java Coding Guidelines

@Getter
@Component
@ToString
public  class  MsgResult<T> {
    // todo 封装太简单了，最好把Object改成泛型，用builder模式重新封装
    private T t ;
    private Integer code;
    private String message;

    public MsgResult(Builder<T> builder) {
        this.t=builder.t;
        this.code=builder.code;
        this.message=builder.message;
    }
    public MsgResult(){

    }

    public final static class Builder<T>{
        private Integer code;
        private String message;
        private T t;

        public Builder(){
        }

        public Builder<T> setCode(Integer code) {
            this.code = code;
            return this;
        }

        public Builder<T> setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> setT(T t){
            this.t=t;
            return this;
        }
        public MsgResult<T> build(){
            return new MsgResult<T>(this);
        }
        public Builder<T> success(T t){
            this.code=1;
            this.message="success";
            this.t=t;
            return this;
        }
        public Builder<T> fail(Integer code,String message){
            this.code=code;
            this.message=message;
            return this;
        }

    }

}
