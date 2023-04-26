package usescases;

import com.neoris.account.domain.model.account.Account;
import com.neoris.account.domain.model.account.gateways.AccountRepository;
import com.neoris.account.domain.model.client.Client;
import com.neoris.account.domain.model.exception.FailException;
import com.neoris.account.domain.usecase.account.AccountUseCase;
import com.neoris.account.domain.usecase.client.ClientUseCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class AccountUseCaseTest extends UseCaseTestApplication {

    @InjectMocks
    AccountUseCase accountUseCase;

    @Mock
    AccountRepository accountRepository;

    @Before
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldErrorCreateAccount(){

        Account account=getAccount();

        when(accountRepository.validateAccountExist(any(),any())).thenReturn(Boolean.TRUE);

        assertThrows(FailException.class,() -> accountUseCase.create(account));
    }


    @Test
    public void shouldCreateAccount() throws FailException {

        Account account=getAccount();

        when(accountRepository.validateAccountExist(any(),any())).thenReturn(Boolean.FALSE);
        when(accountRepository.save(any())).thenReturn(account);

        Account accounRes= accountUseCase.create(account);
        assertEquals(account,accounRes);
    }
}
