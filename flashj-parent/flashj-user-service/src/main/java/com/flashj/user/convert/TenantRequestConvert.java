package com.flashj.user.convert;

import com.flashj.user.dto.tenant.CreateTenantRequestDTO;
import com.flashj.user.entity.Tenant;
import org.springframework.beans.BeanUtils;

public class TenantRequestConvert {

    public static CreateTenantRequestDTO entity2dto(Tenant entity) {
        CreateTenantRequestDTO dto = new CreateTenantRequestDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static Tenant dto2entity(CreateTenantRequestDTO dto) {
        Tenant tenant = new Tenant();
        BeanUtils.copyProperties(dto, tenant);
        return tenant;
    }
}
