package com.neoris.account.domain.usecase.log;

import com.neoris.account.domain.model.logs.Logs;
import com.neoris.account.domain.model.logs.gateways.LogsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class LogUseCase {

    private final LogsRepository repository;

    @Transactional
    public Logs save(Logs log){
        return  repository.save(log);
    }
}
