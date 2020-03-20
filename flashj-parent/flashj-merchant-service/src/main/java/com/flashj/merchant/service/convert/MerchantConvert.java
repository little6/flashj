package com.flashj.merchant.service.convert;

import com.flashj.merchant.service.dto.MerchantDTO;
import com.flashj.merchant.service.entity.Merchant;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MerchantConvert {

    //把dto转换成entity
    public static Merchant dto2entity(MerchantDTO merchantDTO) {
        Merchant merchant = new Merchant();
        BeanUtils.copyProperties(merchantDTO, merchant);
        return merchant;
    }

    //把entity转换成dto
    public static MerchantDTO entity2dto(Merchant merchant) {
        MerchantDTO merchantDTO = new MerchantDTO();
        BeanUtils.copyProperties(merchant, merchantDTO);
        return merchantDTO;
    }

    //list之间也可以转换，将entity的List转成MerchantDTO list
    public static List<MerchantDTO> entityList2dtoList(List<Merchant> merchants) {
        return merchants.parallelStream().map(MerchantConvert::entity2dto).collect(Collectors.toList());
    }


    public static void main(String[] args) {
        //将dto转成entity
        Merchant merchant = new Merchant();
        merchant.setUsername("测试");
        merchant.setMobile("123456");
        MerchantDTO merchantDTO = MerchantConvert.entity2dto(merchant);
        System.out.println(merchantDTO);

        //将entity转成dto
        merchantDTO.setMerchantName("商户名称");
        Merchant merchant1 = MerchantConvert.dto2entity(merchantDTO);
        System.out.println(merchant1);

        //定义的list
        List<Merchant> entityList = new ArrayList<>();
        entityList.add(merchant);
        //将lIST转成包含dto的list
        List<MerchantDTO> list = MerchantConvert.entityList2dtoList(entityList);
        System.out.println(list);

    }

}
