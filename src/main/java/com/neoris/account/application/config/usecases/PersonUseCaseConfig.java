package com.neoris.account.application.config.usecases;

import com.neoris.account.domain.model.client.gateways.ClientRepository;
import com.neoris.account.domain.model.person.gateways.PersonRepository;
import com.neoris.account.domain.usecase.client.ClientUseCase;
import com.neoris.account.domain.usecase.person.PersonUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonUseCaseConfig {

    @Bean
    public PersonUseCase createPersonUseCase(PersonRepository repository){
        return new PersonUseCase(repository);
    }
}
