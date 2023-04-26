package com.neoris.account.domain.model.logs.gateways;

import com.neoris.account.domain.model.logs.Logs;

public interface LogsRepository {
    Logs save(Logs logs);
}
