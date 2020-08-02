package com.example.demo.base.utils;

import java.util.concurrent.ThreadLocalRandom;

public class CaptchaGenerator {
    public static String randamGenerator(){
        int num = ThreadLocalRandom.current().nextInt(10);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }

}
