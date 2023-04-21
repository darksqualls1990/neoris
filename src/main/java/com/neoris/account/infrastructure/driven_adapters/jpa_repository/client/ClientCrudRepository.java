package com.neoris.account.infrastructure.driven_adapters.jpa_repository.client;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ClientCrudRepository extends CrudRepository<ClientEntity, Long>, QueryByExampleExecutor<ClientEntity> {
}
