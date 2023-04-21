package com.neoris.account.domain.usecase.account;

import com.neoris.account.domain.model.account.Account;
import com.neoris.account.domain.model.account.gateways.AccountRepository;
import com.neoris.account.domain.model.exception.FailException;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class AccountUseCase {

    private final AccountRepository accountRepository;

    public Account create(Account account) throws FailException {
        if(accountRepository.validateAccountExist(account.getAccountNumber(),account.getAccountType())){
            throw new FailException(this.getClass(),"Ya existe una cuenta con este numero y tipo");
        }
        return accountRepository.save(account);
    }

    public Account update(Account account){
        return accountRepository.save(account);
    }

    public Account findByid(Long idAccount) throws FailException {
        checkIfExist(idAccount);
        return accountRepository.findById(idAccount);
    }

    public boolean delete(Long idAccount) throws FailException {
        checkIfExist(idAccount);
        return accountRepository.delete(idAccount);
    }

    private void checkIfExist(Long idAccount) throws FailException {
        if(!accountRepository.exist(idAccount)){
            throw new FailException(this.getClass(),"No existe la cuenta");
        }
    }
}
