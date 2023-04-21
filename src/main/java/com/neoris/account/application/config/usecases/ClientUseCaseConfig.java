package com.neoris.account.application.config.usecases;

import com.neoris.account.domain.model.client.gateways.ClientRepository;
import com.neoris.account.domain.usecase.client.ClientUseCase;
import com.neoris.account.domain.usecase.person.PersonUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientUseCaseConfig {

    @Bean
    public ClientUseCase createClientUseCase(ClientRepository repository, PersonUseCase personUseCase){
        return new ClientUseCase(repository,personUseCase);
    }
}
