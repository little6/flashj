package com.flashj.user.convert;

import com.flashj.user.dto.tenant.TenantDTO;
import com.flashj.user.entity.Tenant;
import org.springframework.beans.BeanUtils;

public class TenantConvert {

    public static TenantDTO entity2dto(Tenant entity) {
        TenantDTO tenantDTO = new TenantDTO();
        BeanUtils.copyProperties(entity, tenantDTO);
        return tenantDTO;
    }

    public static Tenant dto2entity(TenantDTO dto) {
        Tenant tenant = new Tenant();
        BeanUtils.copyProperties(dto, tenant);
        return tenant;
    }
}
