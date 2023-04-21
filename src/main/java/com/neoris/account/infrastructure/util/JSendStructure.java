package com.neoris.account.infrastructure.util;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder(toBuilder = true)
public class JSendStructure {

    private JSendStatus status;
    private String message;
    private String errorCode;

    private Map<String, Object> data;

    public void addData(String key, Object object) {
        if (data == null) {
            data = new HashMap<>();
        }
        data.put(key, object);
    }

}