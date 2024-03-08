package com.fishep.common.type;

/**
 * 100 - 999                  保持和http状态码含义一致
 *
 * 1000 - 1999   自定义状态码，发生异常，请求不被接受，系统没有发生更改
 *   1000 - 1099 为一类异常，服务异常，例如：用户名不存在，权限不够 等等
 *   1100 - 1199 为一类异常, 数据格式验证异常，例如：邮箱格式不匹配，手机号不匹配 等等
 *   1200 - 1999 预留，按步长100进行分类
 *
 * 2000 - 2999   自定义状态码，请求已被处理，但可能存在风险
 *   2000 - 2999 预留，按步长100进行分类
 *
 * 3000 - 3999   自定义状态码，处理请求发生错误，不能完成此请求
 *   3000 - 3999 预留，按步长100进行分类
 *
 * 4000 - Integer.MAX_VALUE  自定义状态码，预留
 */
public enum Code {
    SUCCESS(200, Message.SUCCESS),
    FAILURE(400, Message.FAILURE),
    EXCEPTION(1000, Message.EXCEPTION),
    WARN(2000, Message.WARN),
    ERROR(3000, Message.ERROR);

    private Integer code;
    private String message;

    Code(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
