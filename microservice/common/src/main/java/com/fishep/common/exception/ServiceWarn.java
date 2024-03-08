package com.fishep.common.exception;

import com.fishep.common.type.Code;

import static com.fishep.common.type.Message.__;

public class ServiceWarn extends AppException {

    public ServiceWarn() {
        super(__(Code.WARN.getMessage()), Code.WARN.getCode());
    }

    public ServiceWarn(String message) {
        super(message, Code.WARN.getCode());
    }

    public ServiceWarn(String message, Integer code) {
        super(message, code);
    }

    public ServiceWarn(String message, Throwable cause) {
        super(message, cause, Code.WARN.getCode());
    }

    public ServiceWarn(String message, Throwable cause, Integer code) {
        super(message, cause, code);
    }

    public ServiceWarn(Throwable cause) {
        super(__(Code.WARN.getMessage()), cause, Code.WARN.getCode());
    }

    public ServiceWarn(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace, Code.WARN.getCode());
    }

    public ServiceWarn(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Integer code) {
        super(message, cause, enableSuppression, writableStackTrace, code);
    }
}
