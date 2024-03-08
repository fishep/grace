package com.fishep.common.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static com.fishep.common.type.Message.__;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Code code) {
        this(code.getCode(), __(code.getMessage()));
    }

    public Result(Code code, T data) {
        this(code.getCode(), __(code.getMessage()), data);
    }

    public Result(Code code, String message, T data) {
        this(code.getCode(), message, data);
    }

    public static <T> Result<T> success() {
        return new Result<>(Code.SUCCESS);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(Code.SUCCESS, data);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(Code.SUCCESS, message, data);
    }

    public static <T> Result<T> failure() {
        return new Result<>(Code.FAILURE);
    }

    public static <T> Result<T> failure(T data) {
        return new Result<>(Code.FAILURE, data);
    }

    public static <T> Result<T> failure(String message, T data) {
        return new Result<>(Code.FAILURE, message, data);
    }

}
