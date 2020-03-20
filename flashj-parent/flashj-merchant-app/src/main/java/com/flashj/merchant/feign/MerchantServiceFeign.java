package com.flashj.merchant.feign;

import com.flashj.merchant.service.dto.MerchantDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
@author lybbo
*/
@Component
@FeignClient(name = "flashj-merchant-service")
public interface MerchantServiceFeign {

    @GetMapping("/query/merchant/{id}")
    MerchantDTO queryMerchantById(@PathVariable(value = "id") Long id);
}
