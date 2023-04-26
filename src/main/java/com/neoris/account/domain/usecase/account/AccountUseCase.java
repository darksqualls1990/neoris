package com.neoris.account.domain.usecase.account;

import com.neoris.account.domain.model.account.Account;
import com.neoris.account.domain.model.account.gateways.AccountRepository;
import com.neoris.account.domain.model.exception.FailException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Level;
import java.util.logging.Logger;


@RequiredArgsConstructor
public class AccountUseCase {

    private final AccountRepository accountRepository;

    @Transactional
    public Account create(Account account) throws FailException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO,"init create account");
        if(accountRepository.validateAccountExist(account.getAccountNumber(),account.getAccountType())){
            Logger.getLogger(this.getClass().getName()).log(Level.INFO,"Error account exist - numberAccount: "+account.getAccountNumber()+" accountType:"+account.getAccountType());
            throw new FailException(this.getClass(),"Ya existe una cuenta con este numero y tipo");
        }
        return accountRepository.save(account);
    }

    @Transactional
    public Account update(Account account){
        Logger.getLogger(this.getClass().getName()).log(Level.INFO,"init update account");
        return accountRepository.save(account);
    }

    public Account findByid(Long idAccount) throws FailException {
        checkIfExist(idAccount);
        return accountRepository.findById(idAccount);
    }

    @Transactional
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
