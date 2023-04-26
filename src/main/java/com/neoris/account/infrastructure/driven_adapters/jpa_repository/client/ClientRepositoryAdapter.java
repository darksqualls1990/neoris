package com.neoris.account.infrastructure.driven_adapters.jpa_repository.client;

import com.neoris.account.domain.model.client.Client;
import com.neoris.account.domain.model.client.gateways.ClientRepository;
import com.neoris.account.infrastructure.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository
public class ClientRepositoryAdapter extends AdapterOperations<Client,ClientEntity,Long,ClientCrudRepository> implements  ClientRepository{


    public ClientRepositoryAdapter(ClientCrudRepository repository,ObjectMapper mapper) {
        super(repository,mapper,d -> mapper.mapBuilder(d,Client.ClientBuilder.class).build());
    }

    @Override
    public Collection<Client> finAll() {
        return toList(repository.findAll());
    }

    @Override
    public Client save(Client client) {
        if(client.hasId()){
            client.setStatus(Boolean.TRUE);
        }
        return super.save(client);
    }

}
