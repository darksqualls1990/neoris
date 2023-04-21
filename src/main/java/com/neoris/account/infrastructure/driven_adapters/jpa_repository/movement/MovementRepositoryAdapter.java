package com.neoris.account.infrastructure.driven_adapters.jpa_repository.movement;

import com.neoris.account.domain.model.movement.Movement;
import com.neoris.account.domain.model.movement.gateways.MovementRepository;
import com.neoris.account.infrastructure.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@Repository
public class MovementRepositoryAdapter extends AdapterOperations<Movement,MovementEntity,Long,MovementCrudRepository> implements MovementRepository {


    public MovementRepositoryAdapter(MovementCrudRepository repository, ObjectMapper mapper) {
        super(repository,mapper,d -> mapper.mapBuilder(d,Movement.MovementBuilder.class).build());
    }

    @Override
    public Movement createMovement(Movement movement) {
        movement.setFecha(LocalDateTime.now());
        return super.save(movement);
    }

    @Override
    public Movement findLastMovementAccount(Long idAccount) {
        return toEntity(repository.findLastMovementAccount(idAccount));
    }

}
