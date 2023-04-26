package com.neoris.account.infrastructure.driven_adapters.jpa_repository.logs;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;


public interface LogsDataRepository extends CrudRepository<LogsData, String>, QueryByExampleExecutor<LogsData> {


}
