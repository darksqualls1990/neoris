package com.neoris.account.infrastructure.util;

import com.neoris.account.domain.model.exception.ErrorException;
import com.neoris.account.domain.model.exception.FailException;
import com.neoris.account.domain.model.logs.Logs;
import com.neoris.account.domain.usecase.log.LogUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

public class ResponseEntityUtils {

    public static ResponseEntity<Object> response(JSendStructure jSendResponse,
                                                  Integer statusCode) {
        return ResponseEntity.status(statusCode != null ? statusCode :
                HttpStatus.OK.value()).body(jSendResponse);
    }

    public static ResponseEntity<Object> response(JSendStructure jSendResponse) {
        return response(jSendResponse, null);
    }

    public static ResponseEntity<Object> exceptionResponse(Exception ex, LogUseCase logUseCase) {
        Logs logs;
        ResponseEntity<Object> response = null;
        if (ex instanceof FailException) {
            FailException fx = (FailException) ex;
            ErrorException exf = new ErrorException(fx.getClassConvert(), fx.FUNCIONAL);

            logs=Logs.builder()
                    .message(fx.getLocalizedMessage())
                    .creationUser("USER")
                    .bodyError(exf.getCode())
                    .observation(exf.getClassName())
                    .build();
            response = response(JSendResponse.fail(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR.value());

        } else if (ex instanceof ErrorException) {
            ErrorException e = (ErrorException) ex;
            logs=Logs.builder()
                    .message(((ErrorException) ex).getCode())
                    .creationUser("USER")
                    .bodyError(ex.getMessage())
                    .observation(ex.getMessage())
                    .build();
            response = response(JSendResponse.error(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString()));

        }else {
            logs=Logs.builder()
                    .message(ex.getLocalizedMessage())
                    .creationUser("USER")
                    .bodyError(ex.getMessage())
                    .observation(ex.getMessage())
                    .build();
        }
        logUseCase.save(logs);
        return response != null ? response : response(JSendResponse.error(ex.getMessage(), "0"),
                HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    public static List<String> validateFields(BindingResult result){
        List<String> fieldsRequired=null;
        if (result.hasErrors()) {
            fieldsRequired = result.getFieldErrors().stream()
                    .map(error -> error.getField() + " - " + error.getDefaultMessage())
                    .collect(Collectors.toList());
        }

        return fieldsRequired;
    }
}
