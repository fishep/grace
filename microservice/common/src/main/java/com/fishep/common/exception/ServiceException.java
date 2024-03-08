package com.fishep.common.exception;

import com.fishep.common.type.Code;

import static com.fishep.common.type.Message.__;

public class ServiceException extends AppException {

    public ServiceException() {
        super(__(Code.EXCEPTION.getMessage()), Code.EXCEPTION.getCode());
    }

    public ServiceException(String message) {
        super(message, Code.EXCEPTION.getCode());
    }

    public ServiceException(String message, Integer code) {
        super(message, code);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause, Code.EXCEPTION.getCode());
    }

    public ServiceException(String message, Throwable cause, Integer code) {
        super(message, cause, code);
    }

    public ServiceException(Throwable cause) {
        super(__(Code.EXCEPTION.getMessage()), cause, Code.EXCEPTION.getCode());
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace, Code.EXCEPTION.getCode());
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Integer code) {
        super(message, cause, enableSuppression, writableStackTrace, code);
    }

}
