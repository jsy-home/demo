package com.example.demo.bussiness.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginRequestDTO implements Serializable {
    private static final long serialVersionUID = 8178755178436054135L;
    private String username;
    private String password;
}
