package com.neoris.account.application.config.usecases;

import com.neoris.account.domain.model.report.gateways.AccountStatusRepository;
import com.neoris.account.domain.usecase.report.ReportUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReportUseCaseConfig {

    @Bean
    public ReportUseCase createReportUseCase(AccountStatusRepository repository){
        return new ReportUseCase(repository);
    }
}
