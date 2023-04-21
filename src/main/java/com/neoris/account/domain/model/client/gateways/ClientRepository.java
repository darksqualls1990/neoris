package com.neoris.account.domain.model.client.gateways;

import com.neoris.account.domain.model.client.Client;

import java.util.Collection;

public interface ClientRepository {

    Collection<Client> finAll();

    Client save(Client client);
}
