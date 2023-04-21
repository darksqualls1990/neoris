package com.neoris.account.domain.model.client;

import com.neoris.account.domain.model.person.Person;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Setter
@Getter
public class Client implements Serializable {

    private Long id;
    @NotBlank(message = "El campo es obligatorio")
    private String password;
    private boolean status;
    private String clientId;
    private Person person;

    public boolean hasId(){
        return id == null;
    }

}
