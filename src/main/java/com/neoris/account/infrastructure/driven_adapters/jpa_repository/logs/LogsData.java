package com.neoris.account.infrastructure.driven_adapters.jpa_repository.logs;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "logs")
@NoArgsConstructor
public class LogsData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_log_error")
    private Integer idLogError;
    private String message;
    @Column(name="creation_date")
    private LocalDateTime creationDate;
    @Column(name="creation_user")
    private String creationUser;
    private String observation;
    @Column(name="body_error")
    private String bodyError;


}
