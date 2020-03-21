package com.flashj.merchant.app.test;

import com.flashj.merchant.app.MerchantBootApp;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/*
@author lybbo
*/
@SpringBootTest(classes = MerchantBootApp.class)
@RunWith(SpringRunner.class)
@Slf4j
public class RestTemplateTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void test1() {
        String url = "http://www.baidu.com";
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
        System.out.println(entity.getBody());
    }
}
