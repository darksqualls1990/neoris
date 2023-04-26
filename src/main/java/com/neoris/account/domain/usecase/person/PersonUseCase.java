package com.neoris.account.domain.usecase.person;

import com.neoris.account.domain.model.person.Person;
import com.neoris.account.domain.model.person.gateways.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
public class PersonUseCase {

    private final PersonRepository personRepository;

    @Transactional
    public Person create(Person person){
        return personRepository.save(person);
    }

}
