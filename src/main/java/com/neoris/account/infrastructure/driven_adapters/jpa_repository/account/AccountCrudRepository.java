package com.neoris.account.infrastructure.driven_adapters.jpa_repository.account;


import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface AccountCrudRepository extends CrudRepository<AccountEntity, Long>, QueryByExampleExecutor<AccountEntity> {

    @ReadOnlyProperty
    AccountEntity findByAccountNumberAndAccountType(String accountNumber,String accountType);
}
