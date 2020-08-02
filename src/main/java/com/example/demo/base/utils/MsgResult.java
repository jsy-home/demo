package com.example.demo.base.utils;

public class MsgResult<T> {
    private T data ;
    private Integer code;
    private String message;

    public T getData() {
        return data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

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
        return builder.code(1).message("Success").data(data).build();
    }


    public static <T> MsgResult<T> fail(Integer code,String message){
        Builder<T> builder = builder();
        return builder.code(code).message(message).build();
    }

    public static class Builder<T>{
        private T data ;
        private Integer code;
        private String message;
        public Builder(){}
        public Builder<T> data(T data){
            this.data=data;
            return this;
        }
        public Builder<T> code(Integer code){
            this.code=code;
            return this;
        }
        public Builder<T> message(String message){
            this.message=message;
            return this;
        }

        public MsgResult<T> build(){
            return new MsgResult<>(this);
        }

    }



}
