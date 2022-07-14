package com.mz.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * REST接口统一返回数据工具类封装RestResponse
 * @param <T>
 */
@Data
public class RestResponse<T> implements Serializable {

    private static final long serialVersionUID = 3728877563912075885L;


    private int code;
    private String msg;
    private T data;

    public RestResponse() {

    }

    public RestResponse(int code, String message, T data) {
        this.code = code;
        this.setMsg(message);
        this.data = data;
    }

    public RestResponse(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public RestResponse(int code, String message) {
        this.code = code;
        this.setMsg(message);
    }

    /**
     * 成功时-返回data
     *
     * @param <T>
     * @return
     */
    public static <T> RestResponse<T> success(T data) {
        return new RestResponse<T>(200, null, data);
    }

    /**
     * 成功-不返回data
     *
     * @param <T>
     * @return
     */
    public static <T> RestResponse<T> success(String msg) {
        return new RestResponse<T>(200, msg);
    }

    /**
     * 成功-返回data+msg
     *
     * @param <T>
     * @return
     */
    public static <T> RestResponse<T> success(String msg, T data) {
        return new RestResponse<T>(200, msg, data);
    }

    /**
     * 失败
     *
     * @param <T>
     * @return
     */
    public static <T> RestResponse<T> fail(String msg) {
        return new RestResponse<T>(500, msg, null);
    }

    /**
     * 失败-code
     *
     * @param <T>
     * @return
     */
    public static <T> RestResponse<T> fail(int code, String msg) {
        return new RestResponse<T>(code, msg, null);
    }
}
