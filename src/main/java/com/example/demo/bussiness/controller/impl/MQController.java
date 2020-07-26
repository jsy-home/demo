package com.example.demo.bussiness.controller.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mq")
public class MQController {
    @RequestMapping("/testMq")
    public String testMq() {
        return "success";
    }
}
