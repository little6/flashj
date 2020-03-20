package com.flashj.user.convert;

import com.flashj.user.dto.tenant.AccountDTO;
import com.flashj.user.entity.Account;
import org.springframework.beans.BeanUtils;

public class AccountConvert {

    public static AccountDTO entity2dto(Account entity) {
        AccountDTO accountDTO = new AccountDTO();
        BeanUtils.copyProperties(entity, accountDTO);
        return accountDTO;
    }

    public static Account dto2entity(AccountDTO dto) {
        Account account = new Account();
        BeanUtils.copyProperties(dto, account);
        return account;
    }
}
