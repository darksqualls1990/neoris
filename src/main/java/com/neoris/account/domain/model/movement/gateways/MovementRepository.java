package com.neoris.account.domain.model.movement.gateways;

import com.neoris.account.domain.model.movement.Movement;


public interface MovementRepository {

    Movement createMovement(Movement movement);
    Movement findLastMovementAccount(Long idAccount);

}
