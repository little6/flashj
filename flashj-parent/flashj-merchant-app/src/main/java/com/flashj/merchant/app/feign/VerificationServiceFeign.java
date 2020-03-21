package com.flashj.merchant.app.feign;

import com.flashj.sms.common.domain.RestResponse;
import com.flashj.sms.dto.VerificationInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/*
@author lybbo
*/
@FeignClient(name = "flashj-sms")
@Component
@RequestMapping("/sms")
public interface VerificationServiceFeign {
    @PostMapping(value = "/generate")
    RestResponse<VerificationInfo> generateVerificationInfo(@RequestParam("name") String name,
                                                            @RequestBody Map<String, Object> payload,
                                                            @RequestParam("effectiveTime") int effectiveTime);
}
