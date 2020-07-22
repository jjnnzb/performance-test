package com.example.performance.entity;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Administrator
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBean<T> implements Serializable {

    private static final long serialVersionUID = -3699842403600131110L;
    /**
     * 状态码
     */
    private int code;

    /**
     * 消息
     */
    private String message;

    /**
     * 结果数据
     */
    private T data;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public static <T> ResponseBean<T> success() {
        return new ResponseBean(ErrorEnum.SUCCESS.getErrorCode(), ErrorEnum.SUCCESS.getErrorMsg(), null);
    }

    public static <T> ResponseBean<T> success(T data) {
        return new ResponseBean(ErrorEnum.SUCCESS.getErrorCode(), ErrorEnum.SUCCESS.getErrorMsg(), data);
    }

    public static <T> ResponseBean<T> success(T data, String message) {
        return new ResponseBean(ErrorEnum.SUCCESS.getErrorCode(), message, data);
    }

    public static <T> ResponseBean<T> error(int code, String message) {
        return new ResponseBean(code, message, null);
    }

    public static ResponseBean error(String message) {
        return new ResponseBean(ErrorEnum.FAIL.getErrorCode(), message, null);
    }

}
