package usescases;

import com.neoris.account.domain.model.client.gateways.ClientRepository;
import com.neoris.account.domain.usecase.client.ClientUseCase;
import com.neoris.account.domain.usecase.person.PersonUseCase;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ClientUseCaseTest extends UseCaseTestApplication {

    @InjectMocks
    ClientUseCase clientUseCase;

    @Mock
    ClientRepository clientRepository;

    @Mock
    PersonUseCase personUseCase;

    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    /*@Test
    public void shouldCreateClient(){

        Client clientSend=getClient();

        when(personUseCase.create(any())).thenReturn(clientSend.getPerson());
        when(clientRepository.save(any())).thenReturn(clientSend);
        Client clientResponse=clientUseCase.create(clientSend);
        assertEquañs(clientResponse,clientSend);
    }*/
}
