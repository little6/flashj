package com.flashj.user.convert;

import com.flashj.user.dto.tenant.AccountDTO;
import com.flashj.user.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountConvert {

    AccountConvert INSTANCE = Mappers.getMapper(AccountConvert.class);

    //@Mappings({
    //        @Mapping(target="username", source="username")
    //})
    AccountDTO entity2dto(Account entity);


    //@Mappings({
    //        @Mapping(target="username", source="username"),
    //        @Mapping(target = "mobile",source="mobile"),
    //        @Mapping(target = "password",source="password"),
    //        @Mapping(target = "salt",source="salt")
    //})
    Account dto2entity(AccountDTO dto);

}
