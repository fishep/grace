package com.fishep.common.exception;

import com.fishep.common.type.Code;

import static com.fishep.common.type.Message.__;

public class ServiceError extends AppException {

    public ServiceError() {
        super(__(Code.ERROR.getMessage()), Code.ERROR.getCode());
    }

    public ServiceError(String message) {
        super(message, Code.ERROR.getCode());
    }

    public ServiceError(String message, Integer code) {
        super(message, code);
    }

    public ServiceError(String message, Throwable cause) {
        super(message, cause, Code.ERROR.getCode());
    }

    public ServiceError(String message, Throwable cause, Integer code) {
        super(message, cause, code);
    }

    public ServiceError(Throwable cause) {
        super(__(Code.ERROR.getMessage()), cause, Code.ERROR.getCode());
    }

    public ServiceError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace, Code.ERROR.getCode());
    }

    public ServiceError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Integer code) {
        super(message, cause, enableSuppression, writableStackTrace, code);
    }

}
