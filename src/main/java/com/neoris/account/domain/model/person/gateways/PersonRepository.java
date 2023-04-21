package com.neoris.account.domain.model.person.gateways;

import com.neoris.account.domain.model.client.Client;
import com.neoris.account.domain.model.person.Person;


public interface PersonRepository {

    Person save(Person person);
}
