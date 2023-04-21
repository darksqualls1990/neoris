package com.neoris.account.domain.model.account.gateways;

import com.neoris.account.domain.model.account.Account;


public interface AccountRepository {

    Account save(Account account);

    boolean validateAccountExist(String accountNumber,String accountType);

    Account findById(Long idAccount);

    boolean delete(Long idAccount);

    boolean exist(Long idAccount);
}
