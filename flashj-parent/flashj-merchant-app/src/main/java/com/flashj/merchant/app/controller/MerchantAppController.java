package com.flashj.merchant.app.controller;

import com.flashj.merchant.app.feign.MerchantServiceFeign;
import com.flashj.merchant.service.dto.MerchantDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/*
@author lybbo
*/
@RestController
@Slf4j
public class MerchantAppController {

    @Autowired
    private MerchantServiceFeign merchantServiceFeign;

    @Autowired
    private ApplicationContext context;

    @Value("${merchant-app}")
    private String okEnv;

    @Value("${flashj-common}")
    private String kklt;

    @GetMapping("/health")
    public String health() {
        return okEnv + kklt;
    }

    @GetMapping("/configs")
    public String configs() {
        return context.getEnvironment().getProperty("flashj-common");
    }

    @GetMapping("/query/{id}")
    public MerchantDTO queryById(@PathVariable Long id, HttpServletRequest request) {
        log.info("开始进入断点执行,feign调用", request.getRequestURL().toString());
        return merchantServiceFeign.queryMerchantById(id);
    }

    @GetMapping("/query/merchants")
    public List<MerchantDTO> queryAllMerchant() {
        return merchantServiceFeign.queryAllMerchant();
    }
}
