package com.neoris.account.infrastructure.util;

import java.util.Map;

public class JSendResponse {

    public static JSendStructure success(String message) {
        return JSendStructure.builder().status(JSendStatus.SUCCESS).message(message).build();
    }

    public static JSendStructure success(String key, Object data) {
        return success(key, data, null);
    }

    public static JSendStructure success(String key, Object data, String message) {
        JSendStructure response = JSendStructure.builder()
                .status(JSendStatus.SUCCESS)
                .message(message)
                .build();
        response.addData(key, data);
        return response;
    }

    public static JSendStructure success(Map<String, Object> data, String message) {
        return JSendStructure.builder()
                .status(JSendStatus.SUCCESS)
                .data(data)
                .message(message)
                .build();
    }

    public static JSendStructure error(String message, String errorCode) {
        return JSendStructure.builder().status(JSendStatus.ERROR)
                .message(message)
                .errorCode(errorCode)
                .build();
    }

    public static JSendStructure fail(String message) {
        return JSendStructure.builder().status(JSendStatus.FAIL).message(message).build();
    }

}
