package com.flashj.merchant.service.convert;

import com.flashj.merchant.service.dto.StoreDTO;
import com.flashj.merchant.service.entity.Store;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class StoreConvert {

    public static StoreDTO entity2dto(Store entity) {
        StoreDTO storeDTO = new StoreDTO();
        BeanUtils.copyProperties(entity, storeDTO);
        return storeDTO;
    }

    public static Store dto2entity(StoreDTO dto) {
        Store store = new Store();
        BeanUtils.copyProperties(dto, store);
        return store;
    }

    public static List<StoreDTO> listentity2dto(List<Store> stores) {
        return stores.parallelStream().map(StoreConvert::entity2dto).collect(Collectors.toList());
    }
}
