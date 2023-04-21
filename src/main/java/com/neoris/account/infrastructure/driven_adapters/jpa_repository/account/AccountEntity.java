package com.neoris.account.infrastructure.driven_adapters.jpa_repository.account;

import com.neoris.account.infrastructure.driven_adapters.jpa_repository.client.ClientEntity;
import com.neoris.account.infrastructure.driven_adapters.jpa_repository.person.PersonEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "Cuenta")
@NoArgsConstructor
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_cuenta",unique = true)
    private String accountNumber;

    @Column(name = "tipo_cuenta", unique = true, nullable = false)
    private String accountType;

    @Column(name = "saldo_inicial", nullable = false)
    private BigDecimal initialBalance;

    @Column(name = "estado", nullable = false)
    @Type(type="org.hibernate.type.NumericBooleanType")
    private boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private ClientEntity client;


}
