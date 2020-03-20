package com.flashj.merchant.service.convert;

import com.flashj.merchant.service.dto.StoreDTO;
import com.flashj.merchant.service.entity.Store;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StoreConvert {

    StoreConvert INSTANCE = Mappers.getMapper(StoreConvert.class);

    StoreDTO entity2dto(Store entity);

    Store dto2entity(StoreDTO dto);

    List<StoreDTO> listentity2dto(List<Store> staff);
}
