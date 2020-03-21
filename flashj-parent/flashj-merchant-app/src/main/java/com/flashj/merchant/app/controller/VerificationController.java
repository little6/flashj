package com.flashj.merchant.app.controller;

import com.flashj.merchant.app.feign.VerificationServiceFeign;
import com.flashj.sms.common.domain.RestResponse;
import com.flashj.sms.dto.VerificationInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/*
@author lybbo
*/
@RestController
@Slf4j
public class VerificationController {

    @Autowired
    private VerificationServiceFeign verificationServiceFeign;

    @ApiOperation(value = "生成验证信息", notes = "生成验证信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "业务名称", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "payload", value = "业务携带参数，如手机号 ，邮箱", required = true, paramType = "body"),
            @ApiImplicitParam(name = "effectiveTime", value = "验证信息有效期(秒)", dataType = "String", paramType = "query")
    })
    @PostMapping(value = "/generate")
    public RestResponse<VerificationInfo> generateVerificationInfo(@RequestParam("name") String name,
                                                                   @RequestBody Map<String, Object> payload,
                                                                   @RequestParam("effectiveTime") int effectiveTime) {
        return verificationServiceFeign.generateVerificationInfo(name, payload, effectiveTime);
    }
}
