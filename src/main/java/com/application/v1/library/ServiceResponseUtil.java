package com.application.v1.library;

/**
 * @author ttm
 * @data 2017/11/23
 */
public class ServiceResponseUtil {

    public static <T> ServiceResponse success(T obj) {
        ServiceResponse response = new ServiceResponse();
        response.setCode(200);
        response.setMsg("SUCCESS");
        response.setResult(obj);
        return response;
    }

    public static ServiceResponse success() {
        ServiceResponse response = new ServiceResponse();
        response.setCode(200);
        response.setMsg("SUCCESS");
        response.setResult(null);
        return response;
    }

    public static ServiceResponse fail(String msg) {
        ServiceResponse response = new ServiceResponse();
        response.setCode(0);
        response.setMsg(msg);
        response.setResult(null);
        return response;
    }

    public static ServiceResponse error() {
        ServiceResponse response = new ServiceResponse();
        response.setCode(500);
        response.setMsg("SERVICE ERROR");
        response.setResult(null);
        return response;
    }

}
