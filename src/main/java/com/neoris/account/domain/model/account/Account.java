package com.neoris.account.domain.model.account;

import com.neoris.account.domain.model.client.Client;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Setter
@Getter
public class Account implements Serializable {

    private Long id;

    @NotBlank(message = "El campo es obligatorio")
    private String accountNumber;

    @NotBlank(message = "El campo es obligatorio")
    private String accountType;

    private BigDecimal initialBalance;

    private boolean status;

    private Client client;

    public boolean hasId(){
        return id == null;
    }
}
