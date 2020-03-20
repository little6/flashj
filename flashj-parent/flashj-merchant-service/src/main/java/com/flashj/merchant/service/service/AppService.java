package com.flashj.merchant.service.service;

import com.flashj.common.domain.BusinessException;
import com.flashj.merchant.service.dto.AppDTO;

import java.util.List;

/*
@author lybbo
*/
public interface AppService {
    /**
     * 创建应用
     * @param merchantId 商户id
     * @param appDTO 应用信息
     * @return 创建成功的应用信息
     * @throws BusinessException
     */
    AppDTO createApp(Long merchantId, AppDTO appDTO) throws BusinessException;

    /**
     * 根据商户id查询应用列表
     * @param merchantId
     * @return
     * @throws BusinessException
     */
    List<AppDTO> queryAppByMerchant(Long merchantId) throws BusinessException;

    /**
     * 根据应用id查询应用信息
     * @param appId
     * @return
     * @throws BusinessException
     */
    AppDTO getAppById(String appId)throws BusinessException;


    /**
     * 校验应用是否属于商户
     * @param appId
     * @param merchantId
     * @return
     */
    Boolean queryAppInMerchant(String appId, Long merchantId);
}
