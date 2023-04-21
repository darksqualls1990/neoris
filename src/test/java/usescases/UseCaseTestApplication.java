package usescases;

import com.neoris.account.domain.model.client.Client;
import com.neoris.account.domain.model.person.Person;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Collection;

public class UseCaseTestApplication {

    public static final int DEFAULT_LENGTH_RANDOM_STRING=10;

    protected  String generateRandomString(){
        return RandomStringUtils.random(DEFAULT_LENGTH_RANDOM_STRING,Boolean.TRUE,Boolean.FALSE);
    }

    protected Client getClient(){
        return Client.builder().clientId(generateRandomString())
                .id(1L)
                .password(generateRandomString())
                .person(getPerson())
                .status(Boolean.TRUE).build();
    }

    protected Collection<Client> getListClient(){
        Collection<Client> collection=new ArrayList<>();
        collection.add(getClient());

        return collection;
    }

    protected Person getPerson(){
        return Person.builder().idPerson(1L).build();
    }

}
