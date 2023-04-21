package com.neoris.account.application.config.usecases;

import com.neoris.account.domain.model.account.gateways.AccountRepository;
import com.neoris.account.domain.usecase.account.AccountUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountUseCaseConfig {

    @Bean
    public AccountUseCase createAccountUseCase(AccountRepository repository){
        return new AccountUseCase(repository);
    }
}
