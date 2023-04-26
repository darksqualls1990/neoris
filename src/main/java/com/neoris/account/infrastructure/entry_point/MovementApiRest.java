package com.neoris.account.infrastructure.entry_point;

import com.neoris.account.domain.model.exception.FailException;
import com.neoris.account.domain.model.movement.Movement;
import com.neoris.account.domain.usecase.log.LogUseCase;
import com.neoris.account.domain.usecase.movement.MovementUseCase;
import com.neoris.account.infrastructure.util.ResponseEntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.neoris.account.infrastructure.util.JSendResponse.success;
import static com.neoris.account.infrastructure.util.ResponseEntityUtils.exceptionResponse;


@RestController
@RequestMapping("/movement")
public class MovementApiRest {

    @Autowired
    private MovementUseCase movementUseCase;


    @Autowired
    private LogUseCase logUseCase;

    @PostMapping()
    public ResponseEntity<Object> saveMovement(@Valid @RequestBody Movement movement, BindingResult result) {
        ResponseEntity<Object> responseEntity;
        List<String> required=ResponseEntityUtils.validateFields(result);
        if( required!= null){
            responseEntity=ResponseEntity.badRequest().body(required);
        }else{
            try {
                responseEntity=ResponseEntity.ok(success("movement", movementUseCase.createMovement(movement)));
            } catch (FailException e) {
                return exceptionResponse(e,logUseCase);
            }
        }
        return responseEntity;
    }
}
