package com.neoris.account.infrastructure.entry_point;

import com.neoris.account.domain.model.account.Account;
import com.neoris.account.domain.model.client.Client;
import com.neoris.account.domain.model.exception.FailException;
import com.neoris.account.domain.usecase.account.AccountUseCase;
import com.neoris.account.infrastructure.util.ResponseEntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.neoris.account.infrastructure.util.JSendResponse.fail;
import static com.neoris.account.infrastructure.util.JSendResponse.success;
import static com.neoris.account.infrastructure.util.ResponseEntityUtils.exceptionResponse;


@RestController
@RequestMapping("/account")
public class AccountApiRest {

    @Autowired
    private AccountUseCase accountUseCase;

    @PostMapping()
    public ResponseEntity<Object> saveAccount(@Valid @ RequestBody Account account, BindingResult result) {
        ResponseEntity<Object> responseEntity;
        List<String> required=ResponseEntityUtils.validateFields(result);
        if( required!= null){
            responseEntity=ResponseEntity.badRequest().body(required);
        }else{
            try {
                responseEntity=ResponseEntity.ok(success("account", accountUseCase.create(account)));
            } catch (FailException e) {
               return exceptionResponse(e);
            }
        }
        return responseEntity;
    }

    @PutMapping()
    public ResponseEntity<Object> updateAccount(@Valid @ RequestBody Account account, BindingResult result) {
        ResponseEntity<Object> responseEntity;
        List<String> required=ResponseEntityUtils.validateFields(result);
        if( required != null){
            responseEntity=ResponseEntity.badRequest().body(required);
        }else{
            responseEntity=ResponseEntity.ok(success("account", accountUseCase.update(account)));
        }
        return responseEntity;
    }

    @DeleteMapping()
    public ResponseEntity<Object> deleteAccount(@RequestParam("id") Long id) {
        try{
            return ResponseEntity.ok(accountUseCase.delete(id) ? success("Cuenta eliminada") :fail("Error al eliminar la cuenta"));
        }catch (FailException e){
            return exceptionResponse(e);
        }
    }
}
