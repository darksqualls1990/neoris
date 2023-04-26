package com.neoris.account.application.config.usecases;

import com.neoris.account.domain.model.logs.gateways.LogsRepository;
import com.neoris.account.domain.usecase.log.LogUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogUseCaseConfig {

    @Bean
    public LogUseCase createLogUseCase(LogsRepository repository){
        return new LogUseCase(repository);
    }
}
