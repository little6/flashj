package com.flashj.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flashj.user.dto.authorization.PrivilegeTreeDTO;
import com.flashj.user.entity.AuthorizationPrivilegeGroup;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 权限组 Mapper 接口
 * </p>
 *
 */
@Repository
public interface AuthorizationPrivilegeGroupMapper extends BaseMapper<AuthorizationPrivilegeGroup> {

    @Select("select * from authorization_privilege_group")
    List<PrivilegeTreeDTO> selectPrivilegeGroup();
}
