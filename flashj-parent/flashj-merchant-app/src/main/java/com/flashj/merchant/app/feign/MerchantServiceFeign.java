package com.flashj.merchant.app.feign;

import com.flashj.merchant.service.dto.MerchantDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/*
@author lybbo
*/
@Component
@FeignClient(name = "flashj-merchant-service")
@RequestMapping("/merchantservice")
public interface MerchantServiceFeign {

    @GetMapping("/query/merchant/{id}")
    MerchantDTO queryMerchantById(@PathVariable(value = "id") Long id);

    @GetMapping("/query/merchants")
    public List<MerchantDTO> queryAllMerchant();
}
