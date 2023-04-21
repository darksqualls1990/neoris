package com.neoris.account.domain.model.report;

import lombok.*;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AccountStatusReport{

    private LocalDate dateMovement;
    private String name;
    private String account;
    private String  accountType;
    private BigDecimal initialBalance;
    private String status;
    private BigDecimal mov;
    private BigDecimal endingBalance;

}
