package com.application.v1.services;

import com.application.v1.orms.User;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;

/**
 * @auther ttm
 * @date 2017/11/29
 */
public interface BaseService<T, ID extends Serializable> {

    /**
     * 获取用户数据集合
     * @param request 前台请求参数
     * @return
     */
    public List<T> userList(HttpServletRequest request);

}
