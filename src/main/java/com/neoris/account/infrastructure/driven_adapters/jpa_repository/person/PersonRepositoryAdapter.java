package com.neoris.account.infrastructure.driven_adapters.jpa_repository.person;

import com.neoris.account.domain.model.client.Client;
import com.neoris.account.domain.model.person.Person;
import com.neoris.account.domain.model.person.gateways.PersonRepository;
import com.neoris.account.infrastructure.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepositoryAdapter extends AdapterOperations<Person,PersonEntity,Long,PersonCrudRepository> implements PersonRepository {


    public PersonRepositoryAdapter(PersonCrudRepository repository, ObjectMapper mapper) {
        super(repository,mapper,d -> mapper.mapBuilder(d,Person.PersonBuilder.class).build());
    }

    @Override
    public Person save(Person person) {
        return super.save(person);
    }

}
