package com.neoris.account.domain.usecase.person;

import com.neoris.account.domain.model.client.Client;
import com.neoris.account.domain.model.client.gateways.ClientRepository;
import com.neoris.account.domain.model.person.Person;
import com.neoris.account.domain.model.person.gateways.PersonRepository;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.UUID;

@RequiredArgsConstructor
public class PersonUseCase {

    private final PersonRepository personRepository;

    public Person create(Person person){
        return personRepository.save(person);
    }

}
