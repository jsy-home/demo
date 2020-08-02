package com.example.demo.bussiness.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
public class Account implements Serializable {
    private Long id;
    private String password;
    private Long userid;
    private User user;

}
