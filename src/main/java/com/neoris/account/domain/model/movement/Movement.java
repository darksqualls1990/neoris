package com.neoris.account.domain.model.movement;

import com.neoris.account.domain.model.account.Account;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Setter
@Getter
public class Movement implements Serializable {

    private Long id;

    private LocalDateTime fecha;
    @NotBlank(message = "El campo es obligatorio")
    private String movementType;
    @NotNull(message = "Ingrese el valor")
    private BigDecimal value;

    private BigDecimal balance;

    private Account account;

}
