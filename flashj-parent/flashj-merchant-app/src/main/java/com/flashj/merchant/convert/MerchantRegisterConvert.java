package com.flashj.merchant.convert;

import com.flashj.merchant.service.dto.MerchantDTO;
import com.flashj.merchant.vo.MerchantRegisterVO;
import org.springframework.beans.BeanUtils;

/**
 * 将商户注册vo和dto进行转换
 */
public class MerchantRegisterConvert {

    //将dto转成vo
    public static MerchantRegisterVO dto2vo(MerchantDTO merchantDTO) {
        MerchantRegisterVO merchantRegisterVO = new MerchantRegisterVO();
        BeanUtils.copyProperties(merchantDTO, merchantRegisterVO);
        return merchantRegisterVO;
    }

    //将vo转成dto
    public static MerchantDTO vo2dto(MerchantRegisterVO merchantRegisterVO) {
        MerchantDTO merchantDTO = new MerchantDTO();
        BeanUtils.copyProperties(merchantRegisterVO, merchantDTO);
        return merchantDTO;
    }

}
