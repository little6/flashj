package com.flashj.user.convert;


import com.flashj.user.dto.tenant.AccountRoleDTO;
import com.flashj.user.entity.AccountRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountRoleConvert {

    AccountRoleConvert INSTANCE = Mappers.getMapper(AccountRoleConvert.class);

    AccountRoleDTO entity2dto(AccountRole entity);

    AccountRole dto2entity(AccountRoleDTO dto);

    List<AccountRoleDTO> listentity2dto(List<AccountRole> app);
}
