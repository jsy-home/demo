package com.example.demo.bussiness.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Administrator
 */
@Data
public class RegisterRequestDTO implements Serializable {

    private static final long serialVersionUID = -4882656117317165075L;
    private String username;
    private String mobile;
    private String destMailAddress;
    private String ma;
}
