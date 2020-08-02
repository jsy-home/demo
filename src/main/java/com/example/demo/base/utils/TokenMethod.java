package com.example.demo.base.utils;

public class TokenMethod {
    public static String getToken(String id,String salt){
        String str=id+"_"+salt+System.currentTimeMillis();
        String token = MD5Method.getMD5(str);
        return token;
    }
}
