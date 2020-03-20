package com.flashj.merchant.controller;

import com.flashj.merchant.feign.MerchantServiceFeign;
import com.flashj.merchant.service.dto.MerchantDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/*
@author lybbo
*/
@RestController
@Slf4j
public class MerchantAppController {

    @Autowired
    private MerchantServiceFeign merchantServiceFeign;

    @GetMapping("/query/{id}")
    public MerchantDTO queryById(@PathVariable Long id, HttpServletRequest request) {
        log.info("开始进入断点执行,feign调用", request.getRequestURL().toString());
        return merchantServiceFeign.queryMerchantById(id);
    }
}
