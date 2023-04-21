package com.neoris.account.domain.usecase.client;

import com.neoris.account.domain.model.client.Client;
import com.neoris.account.domain.model.client.gateways.ClientRepository;
import com.neoris.account.domain.usecase.person.PersonUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.UUID;

@RequiredArgsConstructor
public class ClientUseCase {

    private final ClientRepository clientRepository;

    @Autowired
    private final PersonUseCase personUseCase;

    public Collection<Client> finAll(){
        return clientRepository.finAll();
    }

    public Client create(Client client){
        client.setClientId(UUID.randomUUID().toString());
        client.setPerson(personUseCase.create(client.getPerson()));
        return clientRepository.save(client);
    }

}
