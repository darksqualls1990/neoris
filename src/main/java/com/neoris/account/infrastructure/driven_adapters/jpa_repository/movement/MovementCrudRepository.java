package com.neoris.account.infrastructure.driven_adapters.jpa_repository.movement;


import com.neoris.account.infrastructure.driven_adapters.jpa_repository.account.AccountEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface MovementCrudRepository extends CrudRepository<MovementEntity, Long>, QueryByExampleExecutor<MovementEntity> {

    @Query(value="SELECT * FROM Movimiento m WHERE m.cuenta_id = :idAccount AND m.fecha = (SELECT MAX(m2.fecha) FROM Movimiento m2 WHERE m2.cuenta_id = :idAccount)",nativeQuery = true)
    MovementEntity findLastMovementAccount(@Param("idAccount") Long idAccount);
}
