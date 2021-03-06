package com.flashj.sms.generator;

import java.util.Random;

public class NumberVerificationCodeGenerator implements VerificationCodeGenerator {

    private int len;

    public NumberVerificationCodeGenerator(int len) {
        this.len = len;
    }

    @Override
    public String generate() {
        return getNumRandom(len);
    }

    private String getNumRandom(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            val += String.valueOf(random.nextInt(10));
        }
        return val;
    }

}
