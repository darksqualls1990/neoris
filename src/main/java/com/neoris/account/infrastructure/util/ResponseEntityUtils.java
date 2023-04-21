package com.neoris.account.infrastructure.util;

import com.neoris.account.domain.model.exception.ErrorException;
import com.neoris.account.domain.model.exception.FailException;
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

    public static ResponseEntity<Object> exceptionResponse(Exception ex) {

        ResponseEntity<Object> response = null;
        if (ex instanceof FailException) {
            FailException fx = (FailException) ex;
            ErrorException exf = new ErrorException(fx.getClassConvert(), fx.FUNCIONAL);
            response = response(JSendResponse.fail(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR.value());
        } else if (ex instanceof ErrorException) {
            ErrorException e = (ErrorException) ex;
            response = response(JSendResponse.error(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString()));
        }

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
