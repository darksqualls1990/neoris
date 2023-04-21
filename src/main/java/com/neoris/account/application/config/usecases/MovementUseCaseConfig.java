package com.neoris.account.application.config.usecases;

import com.neoris.account.domain.model.movement.gateways.MovementRepository;
import com.neoris.account.domain.usecase.movement.MovementUseCase;
import com.neoris.account.domain.usecase.account.AccountUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovementUseCaseConfig {

    @Bean
    public MovementUseCase createMovementUseCase(MovementRepository repository, AccountUseCase accountUseCase){
        return new MovementUseCase(repository,accountUseCase);
    }
}
