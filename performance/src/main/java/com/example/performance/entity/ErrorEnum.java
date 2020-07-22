package com.example.performance.entity;

/**
 * @author
 * @date 2018/9/18
 */
public enum ErrorEnum {
    ERROR_10000(10000, "登录Token过期"),
    ERROR_10001(10001, "未登录"),
    ERROR_10002(10002, "账号在其他地方登陆"),
    SUCCESS(200, "成功"),
    FAIL(400, "失败"),
    UNAUTHORIZED(401, "认证失败"),
    PERMISSION_DENIED(402, "权限错误"),
    PARAMETER_ERROR(403, "参数错误"),
    NOT_FOUND(404, "接口不存在"),
    SERVER_ERROR(500, "服务器内部错误"),


    /**
     * 不推荐使用
     */
    E_400(400, "请求处理异常，请稍后再试"),
    ERROR_401(401, "账号权限不足"),
    ERROR_500(500, "系统内部错误");

    /**
     * 错误码
     */
    private int errorCode;
    /**
     * 错误信息
     */
    private String errorMsg;

    ErrorEnum(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
