package com.neoris.account.infrastructure.driven_adapters.jpa_repository.person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface PersonCrudRepository extends CrudRepository<PersonEntity, Long>, QueryByExampleExecutor<PersonEntity> {

}
