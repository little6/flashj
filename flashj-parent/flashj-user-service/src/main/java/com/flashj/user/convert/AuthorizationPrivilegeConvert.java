package com.flashj.user.convert;

import com.flashj.user.dto.authorization.PrivilegeDTO;
import com.flashj.user.entity.AuthorizationPrivilege;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorizationPrivilegeConvert {
    public static PrivilegeDTO entity2dto(AuthorizationPrivilege entity){
        PrivilegeDTO privilegeDTO=new PrivilegeDTO();
        BeanUtils.copyProperties(entity,privilegeDTO);
        return privilegeDTO;
    }

    public static AuthorizationPrivilege dto2entity(PrivilegeDTO dto){
        AuthorizationPrivilege authorizationPrivilege=new AuthorizationPrivilege();
        BeanUtils.copyProperties(dto,authorizationPrivilege);
        return authorizationPrivilege;
    }

    public static List<PrivilegeDTO> entitylist2dto(List<AuthorizationPrivilege> authorizationPrivileges){
        return authorizationPrivileges.parallelStream().map(AuthorizationPrivilegeConvert::entity2dto).collect(Collectors.toList());
    }
}
