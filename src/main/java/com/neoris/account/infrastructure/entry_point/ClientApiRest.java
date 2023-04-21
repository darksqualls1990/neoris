package com.neoris.account.infrastructure.entry_point;

import com.neoris.account.domain.model.client.Client;
import com.neoris.account.domain.usecase.client.ClientUseCase;
import com.neoris.account.infrastructure.util.ResponseEntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.neoris.account.infrastructure.util.JSendResponse.success;


@RestController
@RequestMapping("/client")
public class ClientApiRest {

    @Autowired
    private ClientUseCase clientUseCase;

    @GetMapping()
    public ResponseEntity<Object> findAll() {
        return ResponseEntity.ok(success("Clients", clientUseCase.finAll()));
    }

    @PostMapping()
    public ResponseEntity<Object> saveClient( @Valid @ RequestBody Client client,  BindingResult result) {
        ResponseEntity<Object> responseEntity;
        List<String> required=ResponseEntityUtils.validateFields(result);
        if( required!= null){
            responseEntity=ResponseEntity.badRequest().body(required);
        }else{
            responseEntity=ResponseEntity.ok(success("client", clientUseCase.create(client)));
        }
        return responseEntity;
    }
}
