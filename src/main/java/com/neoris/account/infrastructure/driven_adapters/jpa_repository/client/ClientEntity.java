package com.neoris.account.infrastructure.driven_adapters.jpa_repository.client;

import com.neoris.account.infrastructure.driven_adapters.jpa_repository.person.PersonEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cliente")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contrasena", nullable = false)
    private String password;
    @Column(name = "estado")
    @Type(type="org.hibernate.type.NumericBooleanType")
    private boolean status;

    @Column(name = "clienteid")
    private String clientId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "persona_id")
    private PersonEntity person;
}

