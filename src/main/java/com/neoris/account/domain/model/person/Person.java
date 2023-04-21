package com.neoris.account.domain.model.person;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person implements Serializable {

    private Long idPerson;
    @NotBlank(message = "El campo es obligatorio")
    private String name;
    private String gender;
    private Integer age;
    private String identification;
    @NotBlank(message = "El campo es obligatorio")
    private String address;
    @NotBlank(message = "El campo es obligatorio")
    private String phone;
}
