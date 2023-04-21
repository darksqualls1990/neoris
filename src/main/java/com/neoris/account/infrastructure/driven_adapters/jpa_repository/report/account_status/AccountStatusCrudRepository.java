package com.neoris.account.infrastructure.driven_adapters.jpa_repository.report.account_status;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.time.LocalDate;
import java.util.List;

public interface AccountStatusCrudRepository extends CrudRepository<AccountStatusEntity, String>, QueryByExampleExecutor<AccountStatusEntity> {

    @Query(value = "SELECT " +
            " row_number() over() id," +
            "    Date(m.fecha)  datem," +
            "    p.nombre  name," +
            "    c.numero_cuenta   account," +
            "    c.tipo_cuenta ," +
            "    c.saldo_inicial  initial," +
            "    CASE c.estado  " +
            "        WHEN 1 THEN 'Activo'" +
            "        WHEN 0 THEN 'Inactivo'" +
            "        ELSE ''" +
            "    END  status," +
            "    CASE WHEN m.tipo_movimiento = 'CREDIT' THEN m.valor ELSE ( -1)*m.valor END  movimiento  ," +
            "  m.saldo   ending " +
            "FROM " +
            "    cuenta c " +
            "    INNER JOIN cliente cl on c.client_id = cl.id  " +
            "    INNER JOIN persona p ON cl.persona_id  = p.id_person  " +
            "    INNER JOIN movimiento m ON c.id  = m.cuenta_id  AND Date(m.fecha)  BETWEEN :dateInit AND :dateEnd" +
            " WHERE " +
            "    trim(upper(p.nombre)) = trim(upper(:name)) " +
            "order by account," +
            "datem desc", nativeQuery = true)
    List<AccountStatusEntity> getAccountStatus(@Param("dateInit") LocalDate dateInit,
                                               @Param("dateEnd") LocalDate dateEnd,
                                               @Param("name") String name);
}
