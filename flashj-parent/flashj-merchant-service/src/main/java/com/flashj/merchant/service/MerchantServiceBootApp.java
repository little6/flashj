package com.flashj.merchant.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan(basePackages = {"com.flashj.merchant.service.mapper"})
public class MerchantServiceBootApp {
    public static void main(String[] args) {
        SpringApplication.run(MerchantServiceBootApp.class, args);
    }
}
