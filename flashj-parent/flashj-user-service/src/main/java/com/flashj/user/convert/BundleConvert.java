package com.flashj.user.convert;

import com.flashj.user.dto.tenant.BundleDTO;
import com.flashj.user.entity.Bundle;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BundleConvert {

    BundleConvert INSTANCE = Mappers.getMapper(BundleConvert.class);

    BundleDTO entity2dto(Bundle entity);

    Bundle dto2entity(BundleDTO dto);

    List<BundleDTO> entitylist2dto(List<Bundle> bundle);
}
