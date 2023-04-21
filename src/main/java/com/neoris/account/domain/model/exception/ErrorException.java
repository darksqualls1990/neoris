package com.neoris.account.domain.model.exception;

import lombok.Data;

@Data
public class ErrorException extends Exception {

    public static final String GENERAL = "GEN";
    private Class mClass;
    private String code;

    public ErrorException(Class mClass, String code) {
        super();
        this.mClass = mClass;
        this.code = code;
    }

    public String getClassName() {
        return mClass.getName();
    }

}
