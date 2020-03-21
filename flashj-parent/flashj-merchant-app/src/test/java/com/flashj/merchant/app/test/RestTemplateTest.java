package com.flashj.merchant.app.test;

import cn.hutool.core.map.MapUtil;
import com.alibaba.fastjson.JSON;
import com.flashj.merchant.app.MerchantBootApp;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void testSendSmsCode() {
        String url = "http://localhost:9009/sms/generate?name=sms&effectiveTime=120";
        String mobile = "12344443554";
        Map<String, Object> body = new HashMap<>();
        body.put("mobile", mobile);
        //设置请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        //设置请求参数为JSON
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        //封装请求参数
        HttpEntity entity = new HttpEntity(body, httpHeaders);
        Map response;

        ResponseEntity<Map> exchange = restTemplate.exchange(url, HttpMethod.POST, entity, Map.class);
        log.info("调用短信微服务发送验证码,返回值是: {} ", JSON.toJSONString(exchange));
        response = exchange.getBody();

        //去除响应体中的result数据
        if (MapUtil.isNotEmpty(response) || response.get("result") != null) {
            Map<String, Object> map = (Map<String, Object>) response.get("result");
            System.out.println(map.get("key").toString());
        }
    }
}
