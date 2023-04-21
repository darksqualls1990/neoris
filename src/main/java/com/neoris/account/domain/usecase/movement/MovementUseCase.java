package com.neoris.account.domain.usecase.movement;

import com.neoris.account.domain.model.account.Account;
import com.neoris.account.domain.model.exception.FailException;
import com.neoris.account.domain.model.movement.Movement;
import com.neoris.account.domain.model.movement.gateways.MovementRepository;
import com.neoris.account.domain.usecase.account.AccountUseCase;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class MovementUseCase {

    private final MovementRepository movementRepository;

    @Autowired
    private final AccountUseCase accountUseCase;


    public Movement createMovement(Movement movement) throws FailException {

        Movement movenExis=movementRepository.findLastMovementAccount(movement.getAccount().getId());
        if(movenExis == null){
            Account account=accountUseCase.findByid(movement.getAccount().getId());
            movement.setBalance(account.getInitialBalance());
        }else{
            movement.setBalance(movenExis.getBalance());
        }
        validateTypeMovement(movement);
        validateBalance(movement);

        return movementRepository.createMovement(movement);
    }

    private Movement validateTypeMovement(Movement movement){

        if(StringUtils.equals(movement.getMovementType(),"DEBIT")){
            movement.setBalance(movement.getBalance().subtract(movement.getValue()));
        }else{
            movement.setBalance(movement.getBalance().add(movement.getValue()));
        }
        return movement;
    }

    private void validateBalance(Movement movement) throws FailException {
        if(movement.getBalance().compareTo(BigDecimal.ZERO) < 0){
            throw new FailException(this.getClass(),"Saldo no disponible");
        }
    }

}
