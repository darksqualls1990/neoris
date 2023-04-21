package com.neoris.account.infrastructure.driven_adapters.jpa_repository.report.account_status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Entity
@NoArgsConstructor
public class AccountStatusEntity {

    @Id
    private String id;
    @Column(name = "datem")
    private LocalDate dateMovement;
    private String name;
    private String account;
    @Column(name = "tipo_cuenta")
    private String  accountType;
    @Column(name = "initial")
    private BigDecimal initialBalance;
    private String status;
    @Column(name = "movimiento")
    private BigDecimal mov;
    @Column(name = "ending")
    private BigDecimal endingBalance;
}
