package com.flashj.user.convert;

import com.flashj.user.dto.authorization.RoleDTO;
import com.flashj.user.entity.AuthorizationRole;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorizationRoleConvert {

    public static RoleDTO entity2dto(AuthorizationRole entity) {
        RoleDTO roleDTO = new RoleDTO();
        BeanUtils.copyProperties(entity, roleDTO);
        return roleDTO;
    }

    public static AuthorizationRole dto2entity(RoleDTO dto) {
        AuthorizationRole authorizationRole = new AuthorizationRole();
        BeanUtils.copyProperties(dto, authorizationRole);
        return authorizationRole;
    }

    public static List<RoleDTO> entitylist2dto(List<AuthorizationRole> authorizationRoles) {
        return authorizationRoles.parallelStream().map(AuthorizationRoleConvert::entity2dto).collect(Collectors.toList());
    }

    public static List<AuthorizationRole> dtolist2entity(List<RoleDTO> roleDTOS) {
        return roleDTOS.parallelStream().map(AuthorizationRoleConvert::dto2entity).collect(Collectors.toList());
    }

}
