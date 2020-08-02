package com.example.demo.bussiness.entity;


import lombok.*;


@Data
public class User {
    private Long id;

    private String username;

    private String mobile;
    private String headImg;

    private Byte verifyFlag;

    private Byte enableFlag;


}