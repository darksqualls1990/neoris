package com.neoris.account.infrastructure.driven_adapters.jpa_repository.movement;

import com.neoris.account.infrastructure.driven_adapters.jpa_repository.account.AccountEntity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Movimiento")
public class MovementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "tipo_movimiento", nullable = false)
    private String movementType;

    @Column(name = "valor", precision = 10, scale = 2)
    private BigDecimal value;

    @Column(name = "saldo", precision = 10, scale = 2)
    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuenta_id", nullable = false)
    private AccountEntity account;

}
