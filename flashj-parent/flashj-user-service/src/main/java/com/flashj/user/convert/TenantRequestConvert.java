package com.flashj.user.convert;

import com.flashj.user.dto.tenant.CreateTenantRequestDTO;
import com.flashj.user.entity.Tenant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TenantRequestConvert {

    TenantRequestConvert INSTANCE = Mappers.getMapper(TenantRequestConvert.class);

    CreateTenantRequestDTO entity2dto(Tenant entity);

    Tenant dto2entity(CreateTenantRequestDTO dto);
}
