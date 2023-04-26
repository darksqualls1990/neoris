package usescases;

import com.neoris.account.domain.model.client.Client;
import com.neoris.account.domain.model.client.gateways.ClientRepository;
import com.neoris.account.domain.usecase.client.ClientUseCase;
import com.neoris.account.domain.usecase.person.PersonUseCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ClientUseCaseTest extends UseCaseTestApplication {

    @InjectMocks
    ClientUseCase clientUseCase;

    @Mock
    ClientRepository clientRepository;

    @Mock
    PersonUseCase personUseCase;

    @Before
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldCreateClient(){

        Client clientSend=getClient();

        when(personUseCase.create(any())).thenReturn(clientSend.getPerson());
        when(clientRepository.save(any())).thenReturn(clientSend);
        Client clientResponse=clientUseCase.create(clientSend);
        assertEquals(clientResponse, clientSend);
    }
}
