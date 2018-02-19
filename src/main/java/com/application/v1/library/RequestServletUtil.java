package com.application.v1.library;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RequestServletUtil {

    /**
     * 获取session
     * @return
     */
    public static HttpSession fetchSession() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession(false);
    }

    /**
     * 获取请求
     * @return
     */
    public static HttpServletRequest fetchRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

}
