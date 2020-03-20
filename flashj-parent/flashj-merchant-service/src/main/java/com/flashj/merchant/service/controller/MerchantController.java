package com.flashj.merchant.service.controller;

import com.flashj.common.domain.BusinessException;
import com.flashj.common.domain.PageVO;
import com.flashj.merchant.service.dto.MerchantDTO;
import com.flashj.merchant.service.dto.StaffDTO;
import com.flashj.merchant.service.dto.StoreDTO;
import com.flashj.merchant.service.service.MerchantService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
@author lybbo
*/
@RestController
@Slf4j
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @ApiOperation(value = "根据id查询商户")
    @GetMapping("/query/merchant/{id}")
    public MerchantDTO queryMerchantById(@PathVariable("id") Long id) {
        return merchantService.queryMerchantById(id);
    }

    @ApiOperation(value = "根据租户id查询商户的信息")
    @GetMapping("/query/tenant/{id}")
    public MerchantDTO queryMerchantByTenantId(@PathVariable("id") Long tenantId) {
        return merchantService.queryMerchantByTenantId(tenantId);
    }

    @ApiOperation(value = "注册商户服务接口，接收账号、密码、手机号，为了可扩展性使用merchantDto接收数据")
    @PostMapping("/create/merchant")
    MerchantDTO createMerchant(@RequestBody MerchantDTO merchantDTO) throws BusinessException {
        return merchantService.createMerchant(merchantDTO);
    }

    @ApiOperation(value = "资质申请")
    @PostMapping("/apply")
    void applyMerchant(Long merchantId, MerchantDTO merchantDTO) throws BusinessException {
        merchantService.applyMerchant(merchantId, merchantDTO);
    }


    @ApiOperation(value = "新增门店")
    @PostMapping("/create/store")
    StoreDTO createStore(StoreDTO storeDTO) throws BusinessException {
        return merchantService.createStore(storeDTO);
    }


    @ApiOperation(value = "新增员工")
    @PostMapping("/create/staff")
    StaffDTO createStaff(StaffDTO staffDTO) throws BusinessException {
        return merchantService.createStaff(staffDTO);
    }


    @ApiOperation(value = "将员工设置为门店的管理员")
    void bindStaffToStore(Long storeId, Long staffId) throws BusinessException {
        merchantService.bindStaffToStore(storeId,staffId);
    }

    @ApiOperation(value = "门店列表的查询")
    @GetMapping("/query/store/list")
    PageVO<StoreDTO> queryStoreByPage(StoreDTO storeDTO, Integer pageNo, Integer pageSize) {
        return merchantService.queryStoreByPage(storeDTO,pageNo,pageSize);
    }

    @ApiOperation(value = "校验门店是否属于商户")
    Boolean queryStoreInMerchant(Long storeId, Long merchantId) {
        return merchantService.queryStoreInMerchant(storeId,merchantId);
    }
}
