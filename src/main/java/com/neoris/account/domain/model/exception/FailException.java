package com.neoris.account.domain.model.exception;

public class FailException extends Exception {

    public static final String FUNCIONAL = "FUN";
    private Class mClass;

    public FailException(Class mClass, String message) {
        super(message);
        this.mClass = mClass;
    }

    public Class getClassConvert() {
        return mClass;
    }

    public void setmClass(Class mClass) {
        this.mClass = mClass;
    }
}
