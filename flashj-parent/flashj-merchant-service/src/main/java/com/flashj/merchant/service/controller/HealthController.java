package com.flashj.merchant.service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
@author lybbo
*/
@RestController
public class HealthController {

    @Value("${spring.datasource.password}")
    private String dbPort;

    @Value("${hikari}")
    private String hikari;

    @Value("${mplus}")
    private String mplus;

    @GetMapping("/health")
    public String health() {
        return dbPort + hikari + mplus;
    }
}
