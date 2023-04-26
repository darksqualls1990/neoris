package com.neoris.account.domain.usecase.movement;

import com.neoris.account.domain.model.account.Account;
import com.neoris.account.domain.model.exception.FailException;
import com.neoris.account.domain.model.movement.Movement;
import com.neoris.account.domain.model.movement.gateways.MovementRepository;
import com.neoris.account.domain.usecase.account.AccountUseCase;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequiredArgsConstructor
public class MovementUseCase {

    private final MovementRepository movementRepository;

    @Autowired
    private final AccountUseCase accountUseCase;

    @Transactional
    public Movement createMovement(Movement movement) throws FailException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO,"init create movement");
        Movement movenExis=movementRepository.findLastMovementAccount(movement.getAccount().getId());
        if(movenExis == null){
            Logger.getLogger(this.getClass().getName()).log(Level.INFO,"Movement  not exist");
            Account account=accountUseCase.findByid(movement.getAccount().getId());
            movement.setBalance(account.getInitialBalance());
        }else{
            Logger.getLogger(this.getClass().getName()).log(Level.INFO,"Movement exist");
            movement.setBalance(movenExis.getBalance());
        }
        validateTypeMovement(movement);
        validateBalance(movement);
        Logger.getLogger(this.getClass().getName()).log(Level.INFO,"init  createMovement");
        return movementRepository.createMovement(movement);
    }

    private Movement validateTypeMovement(Movement movement){
        Logger.getLogger(this.getClass().getName()).log(Level.INFO,"init  validateTypeMovement");
        if(StringUtils.equals(movement.getMovementType(),"DEBIT")){
            Logger.getLogger(this.getClass().getName()).log(Level.INFO,"Movement is debit");
            movement.setBalance(movement.getBalance().subtract(movement.getValue()));
        }else{
            Logger.getLogger(this.getClass().getName()).log(Level.INFO,"Movement is credit");
            movement.setBalance(movement.getBalance().add(movement.getValue()));
        }
        Logger.getLogger(this.getClass().getName()).log(Level.INFO,"finish  validateTypeMovement");
        return movement;
    }

    private void validateBalance(Movement movement) throws FailException {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO,"init  validateBalance");
        if(movement.getBalance().compareTo(BigDecimal.ZERO) < 0){
            Logger.getLogger(this.getClass().getName()).log(Level.INFO,"error  validateBalance balance:"+movement.getBalance());
            throw new FailException(this.getClass(),"Saldo no disponible");
        }
    }

}
