package com.application.v1.library;

import java.io.Serializable;

/**
 * 服务请求返回统一结果
 * @author ttm
 * @data 2017/11/23
 */
public class ServiceResponse<T extends Object> {

    /**
     * 状态码
     */
    private int code;

    /**
     * 错误消息
     */
    private String msg;

    /**
     * 结果
     */
    private T result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
