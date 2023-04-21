package com.neoris.account.infrastructure.driven_adapters.jpa_repository.account;

import com.neoris.account.domain.model.account.Account;
import com.neoris.account.domain.model.account.gateways.AccountRepository;
import com.neoris.account.infrastructure.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;


@Repository
public class AccountRepositoryAdapter extends AdapterOperations<Account,AccountEntity,Long,AccountCrudRepository> implements AccountRepository{


    public AccountRepositoryAdapter(AccountCrudRepository repository, ObjectMapper mapper) {
        super(repository,mapper,d -> mapper.mapBuilder(d,Account.AccountBuilder.class).build());
    }

    @Override
    public Account save(Account account) {
        if(account.hasId()){
            account.setStatus(Boolean.TRUE);
        }
        return super.save(account);
    }

    @Override
    public boolean validateAccountExist(String accountNumber,String accountType) {
        Account account=toEntity(repository.findByAccountNumberAndAccountType(accountNumber,accountType));
        Boolean existAccount=Boolean.FALSE;
        if(null != account){
            existAccount=Boolean.TRUE;
        }

        return  existAccount;
    }

    @Override
    public Account findById(Long idAccount) {
        return super.findById(idAccount);
    }

    @Override
    public boolean delete(Long idAccount) {
        repository.deleteById(idAccount);
        return true;
    }

    @Override
    public boolean exist(Long idAccount) {
        return repository.existsById(idAccount);
    }
}
