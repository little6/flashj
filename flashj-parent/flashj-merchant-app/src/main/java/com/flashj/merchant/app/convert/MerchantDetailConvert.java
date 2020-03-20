package com.flashj.merchant.app.convert;

import com.flashj.merchant.service.dto.MerchantDTO;
import com.flashj.merchant.app.vo.MerchantDetailVO;
import org.springframework.beans.BeanUtils;

/**
 * 将商户资质申请vo和dto进行转换
 */
public class MerchantDetailConvert {

    //将dto转成vo
    public static MerchantDetailVO dto2vo(MerchantDTO merchantDTO){
        MerchantDetailVO merchantDetailVO=new MerchantDetailVO();
        BeanUtils.copyProperties(merchantDTO,merchantDetailVO);
        return merchantDetailVO;
    }
    //将vo转成dto
    public static MerchantDTO vo2dto(MerchantDetailVO merchantDetailVO){
        MerchantDTO merchantDTO=new MerchantDTO();
        BeanUtils.copyProperties(merchantDetailVO,merchantDTO);
        return merchantDTO;
    }

}
