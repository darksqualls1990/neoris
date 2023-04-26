package com.neoris.account.infrastructure.driven_adapters.jpa_repository.logs;


import com.neoris.account.domain.model.logs.Logs;
import com.neoris.account.domain.model.logs.gateways.LogsRepository;
import com.neoris.account.infrastructure.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;


@Repository
public class LogsRepositoryAdapter extends AdapterOperations<Logs, LogsData, String, LogsDataRepository>
        implements LogsRepository {

    @Autowired
    public LogsRepositoryAdapter(LogsDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Logs.LogsBuilder.class).build()); // could be mapper.mapBuilder
    }

    @Override
    public Logs save(Logs logs) {
        logs.setCreationDate(LocalDateTime.now());
        return super.save(logs);
    }


}
