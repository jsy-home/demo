package com.example.demo.bussiness.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBootPropertiesEntity {
    @Value("${salt}")
    private String salt;

    public  String getSalt(){
        return this.salt;
    }
}
