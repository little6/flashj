package com.flashj.user.convert;


import com.flashj.user.dto.tenant.AccountRoleDTO;
import com.flashj.user.entity.AccountRole;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class AccountRoleConvert {

    public static AccountRoleDTO entity2dto(AccountRole entity) {
        AccountRoleDTO accountRoleDTO = new AccountRoleDTO();
        BeanUtils.copyProperties(entity, accountRoleDTO);
        return accountRoleDTO;
    }

    public static AccountRole dto2entity(AccountRoleDTO dto) {
        AccountRole accountRole = new AccountRole();
        BeanUtils.copyProperties(dto, accountRole);
        return accountRole;
    }

    public static List<AccountRoleDTO> listentity2dto(List<AccountRole> accountRoles) {
        return accountRoles.parallelStream().map(AccountRoleConvert::entity2dto).collect(Collectors.toList());
    }

}
