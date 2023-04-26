package com.neoris.account.domain.model.logs;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
public class Logs {
    private Integer idLogError;
    private String message;
    private LocalDateTime creationDate;
    private String creationUser;
    private String observation;
    private String bodyError;
}
